package com.naever.store.domain.cart.dto

data class CartAddRequest(
    val productId: Long,
    val quantity: Int
)
