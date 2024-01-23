package com.naever.store.domain.product.service

import com.naever.store.domain.product.dto.ProductRequest
import com.naever.store.domain.product.dto.ProductResponse

interface ProductService {

    fun registerProduct(request: ProductRequest): ProductResponse
}