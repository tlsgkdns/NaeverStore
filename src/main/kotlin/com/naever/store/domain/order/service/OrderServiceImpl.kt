package com.naever.store.domain.order.service

import com.naever.store.domain.exception.ModelNotFoundException
import com.naever.store.domain.order.dto.*
import com.naever.store.domain.order.model.OrderItem
import com.naever.store.domain.order.model.Order
import com.naever.store.domain.order.repository.OrderRepository
import com.naever.store.domain.order.repository.OrderItemRepository
import com.naever.store.domain.user.model.User
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderServiceImpl(
    private val orderItemRepository: OrderItemRepository,
    private val orderRepository: OrderRepository) : OrderService {

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

//    @Transactional
//    override fun selectItem(request: OrderItemRequest): SelectItemResponse {
        // TODO : 장바구니에 담으려면 사용자 id 와 상품 id 를 담을 Cart Entity 가 필요합니다ㅎㅎ
//        val selectedItems = selectItemRepository.save(
//            OrderItem(request.selectedItem, request.quantity)
//        )
//        return SelectItemResponse.fromEntity(selectedItems)
//    }

    @Transactional
    override fun createOrder(request: CreateOrderRequest): OrderDetailResponse {

        // TODO : User Repository 에서 request.userId 로 user 찾기

        val order = orderRepository.save(
            Order(
                // TODO: 찾은 user 넣어주기
                address = request.address
            )
        )

        // TODO : Product Repository 에서 productId 로 product 찾기

        val orderItems = ArrayList<OrderItemResponse>()
        for (orderItemRequest in request.orderItems) {
            orderItems.add(orderItemRepository.save(
                OrderItem(
                order = order,
                // TODO: 찾은 product 넣어주기
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

//        val orderItem = OrderItem(request.product, request.quantity)
//        val savedOrder = orderItemRepository.save(
//            Order(
//                orderItems = listOf(orderItem),
//                address = request.address,
////              user = userRepository.findByIdOrNull(request.userId) ?: throw ModelNotFoundException("User", request.userId),
//                status = request.status,
//            )
//        )
//        return OrderDetailResponse.fromEntity(order)
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
