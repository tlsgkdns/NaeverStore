package com.naever.store.domain.cart.dto

data class CartResponse(
    val productId: Long,
    val userId: Long,
    val quantity: Int
)