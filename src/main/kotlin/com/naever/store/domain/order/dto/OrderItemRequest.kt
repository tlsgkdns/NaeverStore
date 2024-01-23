package com.naever.store.domain.order.dto

data class OrderItemRequest(
    val productId: Long,
    val quantity: Long,
)
