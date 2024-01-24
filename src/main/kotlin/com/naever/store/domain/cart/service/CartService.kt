package com.naever.store.domain.cart.service

import com.naever.store.domain.cart.dto.CartResponse
import com.naever.store.domain.cart.model.Cart

interface CartService {
    fun addItemInCart(): CartResponse
    fun getCart(): List<Cart>
    fun deleteCart()
    fun deleteItemInCart()
}