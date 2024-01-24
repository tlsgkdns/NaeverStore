package com.naever.store.domain.cart.repository

import com.naever.store.domain.cart.model.Cart
import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository: JpaRepository<Cart, Long> {
}