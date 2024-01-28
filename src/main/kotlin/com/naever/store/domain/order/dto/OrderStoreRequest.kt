package com.naever.store.domain.order.dto

data class OrderStoreRequest(
    val storeId: Long,
    val orderItems: List<OrderItemRequest>
)
