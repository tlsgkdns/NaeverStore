package com.naever.store.domain.order.service

import com.naever.store.domain.exception.ForbiddenException
import com.naever.store.domain.exception.ModelNotFoundException
import com.naever.store.domain.order.dto.*
import com.naever.store.domain.order.model.OrderItem
import com.naever.store.domain.order.model.Order
import com.naever.store.domain.order.model.OrderStatus
import com.naever.store.domain.order.repository.OrderRepository
import com.naever.store.domain.order.repository.OrderItemRepository
import com.naever.store.domain.product.repository.IProductRepository
import com.naever.store.domain.user.repository.UserRepository
import com.naever.store.infra.security.UserPrincipal
import com.naever.store.infra.security.jwt.CustomAuthenticationToken
import org.springframework.boot.Banner.Mode
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderServiceImpl(
    private val orderItemRepository: OrderItemRepository,
    private val orderRepository: OrderRepository,
    private val productRepository: IProductRepository,
    private val userRepository: UserRepository
) : OrderService {

    override fun findAllByUser(userId: Long): List<OrderDetailResponse> {
        val user = userRepository.findByIdOrNull(userId) ?: throw ModelNotFoundException("User", userId)
        return orderRepository.findByUser(user).map { order ->
            val orderItemsResponse = orderItemRepository.findByOrder(order).map { OrderItemResponse.fromEntity(it) }
            OrderDetailResponse(
                order = OrderResponse.fromEntity(order),
                orderItems = orderItemsResponse
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

        val orderItemResponse = orderItemRepository.findByOrder(foundOrder).map { OrderItemResponse.fromEntity(it) }
        return OrderDetailResponse(
            order = OrderResponse.fromEntity(foundOrder),
            orderItems = orderItemResponse
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
            order = OrderResponse.fromEntity(order),
            orderItems = orderItems
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
        val updatedOrder = orderRepository.save(order)

        val orderItemsResponse = updatedOrder.let { order ->
            orderItemRepository.findByOrder(order).map { OrderItemResponse.fromEntity(it) }
        }
        return OrderDetailResponse(
            order = OrderResponse.fromEntity(updatedOrder),
            orderItems = orderItemsResponse
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

        val orderItemsResponse = order.let { order ->
            orderItemRepository.findByOrder(order).map { OrderItemResponse.fromEntity(it) }
        }

        return OrderDetailResponse(
            order = OrderResponse.fromEntity(order),
            orderItems = orderItemsResponse
        )
    }
}
