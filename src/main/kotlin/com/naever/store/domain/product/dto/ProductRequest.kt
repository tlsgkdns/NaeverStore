package com.naever.store.domain.product.dto

data class ProductRequest(
    val itemName: String,
    val price: Int,
    val stock: Int,
    val description: String
)