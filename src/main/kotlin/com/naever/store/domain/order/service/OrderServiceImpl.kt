package com.naever.store.domain.order.service

import com.naever.store.domain.exception.ModelNotFoundException
import com.naever.store.domain.order.dto.*
import com.naever.store.domain.order.model.OrderItem
import com.naever.store.domain.order.model.Order
import com.naever.store.domain.order.repository.OrderRepository
import com.naever.store.domain.order.repository.OrderItemRepository
import com.naever.store.domain.product.repository.IProductRepository
import com.naever.store.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderServiceImpl(
    private val orderItemRepository: OrderItemRepository,
    private val orderRepository: OrderRepository,
    private val productRepository: IProductRepository,
    private val userRepository: UserRepository
) : OrderService {

    override fun findAll(): List<OrderDetailResponse> {
        val foundOrders = orderItemRepository.findAll()
//        return foundOrders.map{ OrderDetailResponse.fromEntity(it) }
        TODO()
    }

    override fun findById(orderId: Long): OrderDetailResponse {
        val foundOrder = orderItemRepository.findByIdOrNull(orderId)
            ?: throw ModelNotFoundException("Order", orderId)
//        return OrderDetailResponse.fromEntity(foundOrder)
        TODO()
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

        val orderItems = ArrayList<OrderItemResponse>()
        for (orderItemRequest in request.orderItems) {

            val product = productRepository.findProductById(orderItemRequest.productId)
                ?: throw ModelNotFoundException("Product", orderItemRequest.productId)

            product.order(orderItemRequest.quantity)

            orderItems.add(orderItemRepository.save(
                OrderItem(
                    order = order,
                    product = product,
                    quantity = orderItemRequest.quantity
                )
            ).let {
                OrderItemResponse.fromEntity(it)
            })
        }

        return OrderDetailResponse(
            order = OrderResponse.from(order),
            orderItems = orderItems
        )
    }

    @Transactional
    override fun updateOrder(orderId: Long, request: UpdateOrderRequest): OrderDetailResponse {
        val updatedOrder = orderItemRepository.findByIdOrNull(orderId) ?: throw ModelNotFoundException("Order", orderId)

//        updatedOrder.address = request.address
//        updatedOrder.status = request.status

        val savedUpdatedOrder = orderItemRepository.save(updatedOrder)
//        return OrderDetailResponse.fromEntity(savedUpdatedOrder)
        TODO()
    }

    @Transactional
    override fun deleteOrder(orderId: Long) {
        orderItemRepository.deleteById(orderId)
    }
}
