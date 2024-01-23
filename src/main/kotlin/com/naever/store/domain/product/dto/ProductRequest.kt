package com.naever.store.domain.product.dto

data class ProductRequest(
    val itemName: String,
    val price: Int,
    val quantity: Int,
    val description: String
)