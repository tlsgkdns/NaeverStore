package com.naever.store.domain.order.service

import com.naever.store.domain.order.dto.*

interface OrderService {

    fun selectItem(request: SelectItemRequest): SelectItemResponse

    fun findAll(): List<OrderDetailResponse>

    fun findById(orderId: Long): OrderDetailResponse

    fun createOrder(request: CreateOrderRequest): OrderDetailResponse

    fun updateOrder(orderId: Long, request: UpdateOrderRequest): OrderDetailResponse

    fun deleteOrder(orderId: Long)
}

