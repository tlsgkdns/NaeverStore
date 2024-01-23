package com.naever.store.domain.product.service

import com.naever.store.domain.product.dto.ProductPageRequest
import com.naever.store.domain.product.dto.ProductPageResponse
import com.naever.store.domain.product.dto.ProductRequest
import com.naever.store.domain.product.dto.ProductResponse

interface ProductService {

    fun registerProduct(request: ProductRequest): ProductResponse

    fun getProductList(pageNumber: Int, pageSize: Int, request: ProductPageRequest): ProductPageResponse

    fun getProductById(productId: Long): ProductResponse

}