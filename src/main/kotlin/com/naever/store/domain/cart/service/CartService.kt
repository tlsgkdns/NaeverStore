package com.naever.store.domain.cart.service

import com.naever.store.domain.cart.dto.CartAddRequest
import com.naever.store.domain.cart.dto.CartDeleteRequest
import com.naever.store.domain.cart.dto.CartResponse

interface CartService {
    fun addItemInCart(cartAddRequest: CartAddRequest): CartResponse
    fun getCart(): List<CartResponse>
    fun deleteItemInCart(cartDeleteRequest: CartDeleteRequest?)
}