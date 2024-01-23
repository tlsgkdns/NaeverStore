package com.naever.store.domain.order.service

import com.naever.store.domain.exception.ModelNotFoundException
import com.naever.store.domain.order.dto.*
import com.naever.store.domain.order.model.SelectItem
import com.naever.store.domain.order.model.Order
import com.naever.store.domain.order.repository.OrderItemRepository
import com.naever.store.domain.order.repository.SelectItemRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderServiceImpl(
    private val selectItemRepository: SelectItemRepository,
    private val orderItemRepository: OrderItemRepository) : OrderService {

    override fun findAll(): List<OrderDetailResponse> {
        val foundOrders = orderItemRepository.findAll()
        return foundOrders.map{ OrderDetailResponse.fromEntity(it) }
    }

    override fun findById(orderId: Long): OrderDetailResponse {
        val foundOrder = orderItemRepository.findByIdOrNull(orderId)
            ?: throw ModelNotFoundException("Order", orderId)
        return OrderDetailResponse.fromEntity(foundOrder)
    }

    @Transactional
    override fun selectItem(request: SelectItemRequest): SelectItemResponse {
        val selectedItems = selectItemRepository.save(
            SelectItem(request.selectedItem, request.quantity)
        )
        return SelectItemResponse.fromEntity(selectedItems)

    }

    @Transactional
    override fun createOrder(request: CreateOrderRequest): OrderDetailResponse {

        val selectItem = SelectItem(request.product, request.quantity)
        val savedOrder = orderItemRepository.save(
            Order(
                orderItems = listOf(selectItem),
                address = request.address,
//              user = userRepository.findByIdOrNull(request.userId) ?: throw ModelNotFoundException("User", request.userId),
                status = request.status,
            )
        )
        return OrderDetailResponse.fromEntity(savedOrder)
    }

    @Transactional
    override fun updateOrder(orderId: Long, request: UpdateOrderRequest): OrderDetailResponse {
        val updatedOrder = orderItemRepository.findByIdOrNull(orderId) ?: throw ModelNotFoundException("Order", orderId)

        updatedOrder.address = request.address
        updatedOrder.status = request.status

        val savedUpdatedOrder = orderItemRepository.save(updatedOrder)
        return OrderDetailResponse.fromEntity(savedUpdatedOrder)
    }

    @Transactional
    override fun deleteOrder(orderId: Long) {
        orderItemRepository.deleteById(orderId)
    }
}
