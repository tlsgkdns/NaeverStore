package com.naever.store.domain.product.service

import com.naever.store.domain.product.dto.ProductRequest
import com.naever.store.domain.product.dto.ProductResponse
import com.naever.store.domain.product.repository.IProductRepository
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: IProductRepository
) : ProductService {

    override fun registerProduct(request: ProductRequest): ProductResponse {
        TODO("Not yet implemented")
    }

}