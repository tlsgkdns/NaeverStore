package com.naever.store.domain.cart.controller

import com.naever.store.domain.cart.dto.CartAddRequest
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/carts")
class CartController {
    @PostMapping()
    fun addItem(cartAddRequest: CartAddRequest)
    {

    }
    @PreAuthorize("hasAuthority('ROLE_USER') && authentication?.principal?.id == #userId")
    @DeleteMapping("/{userId}")
    fun deleteCartItem(@PathVariable userId: String)
    {

    }
}