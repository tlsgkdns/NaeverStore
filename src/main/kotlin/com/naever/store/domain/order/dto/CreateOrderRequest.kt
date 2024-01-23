package com.naever.store.domain.order.dto

import com.naever.store.domain.product.model.Product

data class CreateOrderRequest(
    val address: String,
    val userId: Long,
    val product: Product,
    val quantity: Long,
    val status: String,
)