package com.naever.store.domain.order.dto

import com.naever.store.domain.order.model.OrderStatus

data class UpdateOrderRequest(
    val address: String,
    val status: OrderStatus,
)