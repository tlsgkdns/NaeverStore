package com.naever.store.domain.order.dto

data class CreateOrderRequest(
    val address: String,
    val orderStores: List<OrderStoreRequest>
)