package com.naever.store.domain.cart.dto

import jakarta.validation.constraints.Min

data class CartAddRequest(
    val productId: Long,
    @field:Min(value = 0, message = "양은 0 이상이야합니다.")
    val quantity: Int
)
