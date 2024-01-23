package com.naever.store.domain.product.repository

import com.naever.store.domain.product.model.Product
import com.naever.store.infra.querydsl.QueryDslSupport

class ProductRepositoryImpl(
    private val productJpaRepository: ProductJpaRepository
) : IProductRepository, QueryDslSupport() {

    override fun save(product: Product): Product {
        return productJpaRepository.save(product)
    }
}