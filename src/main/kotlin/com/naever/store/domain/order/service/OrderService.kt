package com.naever.store.domain.order.service

import com.naever.store.domain.order.dto.*

interface OrderService {

    fun findAll(): List<OrderDetailResponse>

    fun findById(orderId: Long): OrderDetailResponse

    fun createOrder(userId: Long, request: CreateOrderRequest): OrderDetailResponse

    fun updateOrder(orderId: Long, request: UpdateOrderRequest): OrderDetailResponse

    fun deleteOrder(orderId: Long)
}

