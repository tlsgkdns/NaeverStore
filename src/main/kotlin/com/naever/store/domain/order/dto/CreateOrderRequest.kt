package com.naever.store.domain.order.dto

data class CreateOrderRequest(
    val address: String,
    val userId: Long?,
    val orderItems: List<OrderItemRequest>
//    val product: Product,
//    val quantity: Long,
//    val status: String,
)