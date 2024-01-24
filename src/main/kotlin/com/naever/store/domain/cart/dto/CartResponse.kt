package com.naever.store.domain.cart.dto

import com.naever.store.domain.cart.model.Cart

data class CartResponse(
    val productId: Long,
    val userId: Long,
    val quantity: Int
)

{
    companion object {
        fun from(cart: Cart): CartResponse
        {
            return CartResponse(
                userId = cart.user.id!!,
                quantity = cart.quantity,
                productId = cart.product.id!!
            )
        }
    }
}