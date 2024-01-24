package com.naever.store.domain.product.dto

data class ProductPageResponse(
    val pageResult: List<ProductResponse>,
    val totalPages: Int
)
