package com.naever.store.domain.order.service

import com.naever.store.domain.cart.repository.CartRepository
import com.naever.store.domain.exception.ForbiddenException
import com.naever.store.domain.exception.ModelNotFoundException
import com.naever.store.domain.order.dto.*
import com.naever.store.domain.order.model.OrderItem
import com.naever.store.domain.order.model.Order
import com.naever.store.domain.order.model.OrderStatus
import com.naever.store.domain.order.model.OrderStore
import com.naever.store.domain.order.repository.OrderRepository
import com.naever.store.domain.order.repository.OrderItemRepository
import com.naever.store.domain.order.repository.OrderStoreRepository
import com.naever.store.domain.product.repository.IProductRepository
import com.naever.store.domain.store.dto.StoreResponse
import com.naever.store.domain.store.repository.IStoreRepository
import com.naever.store.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderServiceImpl(
    private val orderItemRepository: OrderItemRepository,
    private val orderRepository: OrderRepository,
    private val productRepository: IProductRepository,
    private val userRepository: UserRepository,
    private val cartRepository: CartRepository,
    private val storeRepository: IStoreRepository,
    private val orderStoreRepository: OrderStoreRepository
) : OrderService {

    override fun findAllByUser(userId: Long): List<OrderDetailResponse> {
        val user = userRepository.findByIdOrNull(userId) ?: throw ModelNotFoundException("User", userId)
        return orderRepository.findByUser(user).map { order ->

            val orderStores = orderStoreRepository.findByOrder(order).map { orderStore ->

                OrderStoreResponse(
                    store = StoreResponse.from(orderStore.store),
                    orderItems = orderItemRepository.findByOrderStore(orderStore).map { OrderItemResponse.fromEntity(it) }
                )
            }

            OrderDetailResponse(
                order = OrderResponse.fromEntity(order),
                orderStores = orderStores
            )
        }
    }

    override fun findById(userId: Long, orderId: Long): OrderDetailResponse {
        val user = userRepository.findByIdOrNull(userId)
            ?: throw ModelNotFoundException("User", userId)
        val foundOrder = orderRepository.findByIdOrNull(orderId)
            ?: throw ModelNotFoundException("Order", orderId)

        if (userId != foundOrder.user.id) {
            throw ForbiddenException(userId, "Order", orderId)
        }

        val orderStores = orderStoreRepository.findByOrder(foundOrder).map { orderStore ->

            OrderStoreResponse(
                store = StoreResponse.from(orderStore.store),
                orderItems = orderItemRepository.findByOrderStore(orderStore).map { OrderItemResponse.fromEntity(it) }
            )
        }

        return OrderDetailResponse(
            order = OrderResponse.fromEntity(foundOrder),
            orderStores = orderStores
        )
    }

    @Transactional
    override fun createOrder(userId: Long, request: CreateOrderRequest): OrderDetailResponse {

        val user = userRepository.findByIdOrNull(userId) ?: throw ModelNotFoundException("User", userId)

        val order = orderRepository.save(
            Order(
                user = user,
                address = request.address
            )
        )

        var totalPrice = 0
        val orderStores = request.orderStores.map { storeRequest ->

            val store = storeRepository.findById(storeRequest.storeId) ?: throw ModelNotFoundException("Store", storeRequest.storeId)

            val orderStore = orderStoreRepository.save(OrderStore(
                order = order,
                store = store
            ))

            val orderItems = storeRequest.orderItems.map { itemRequest ->

                val product = productRepository.findProductById(itemRequest.productId)
                    ?: throw ModelNotFoundException("Product", itemRequest.productId)

                product.order(itemRequest.quantity)
                totalPrice += product.price

                orderItemRepository.save(
                    OrderItem(
                        product = product,
                        orderStore = orderStore,
                        quantity = itemRequest.quantity
                    )
                ).let {
                    OrderItemResponse.fromEntity(it)
                }
            }

            cartRepository.deleteItemsInCart(userId, storeRequest.orderItems.map { it.productId })

            OrderStoreResponse(
                store = StoreResponse.from(store),
                orderItems = orderItems
            )
        }

        order.totalPrice = totalPrice

        return OrderDetailResponse(
            order = OrderResponse.fromEntity(order),
            orderStores = orderStores
        )
    }

    @Transactional
    override fun updateOrder(
        userId: Long,
        orderId: Long,
        request: UpdateOrderRequest
    ): OrderDetailResponse {

        val order = orderRepository.findByIdOrNull(orderId) ?: throw ModelNotFoundException("Order", orderId)

        if (userId != order.user.id) {
            throw ForbiddenException(userId, "Order", orderId)
        }
        order.address = request.address
        orderRepository.save(order)

        val orderStores = orderStoreRepository.findByOrder(order).map { orderStore ->

            OrderStoreResponse(
                store = StoreResponse.from(orderStore.store),
                orderItems = orderItemRepository.findByOrderStore(orderStore).map { OrderItemResponse.fromEntity(it) }
            )
        }

        return OrderDetailResponse(
            order = OrderResponse.fromEntity(order),
            orderStores = orderStores
        )
    }

    @Transactional
    override fun deleteOrder(userId: Long, orderId: Long): OrderDetailResponse {
        val order: Order = orderRepository.findByIdOrNull(orderId) ?: throw ModelNotFoundException("Order", orderId)

        if (userId != order.user.id) {
            throw ForbiddenException(userId, "Order", orderId)
        }

        order.status = OrderStatus.CANCELLED
        orderRepository.save(order)

        val orderStores = orderStoreRepository.findByOrder(order).map { orderStore ->

            OrderStoreResponse(
                store = StoreResponse.from(orderStore.store),
                orderItems = orderItemRepository.findByOrderStore(orderStore).map {

                    it.product.cancelOrder(it.quantity)

                    OrderItemResponse.fromEntity(it)
                }
            )
        }

        return OrderDetailResponse(
            order = OrderResponse.fromEntity(order),
            orderStores = orderStores
        )
    }
}
