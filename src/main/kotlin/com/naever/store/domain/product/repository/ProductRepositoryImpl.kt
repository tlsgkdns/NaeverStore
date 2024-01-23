package com.naever.store.domain.product.repository

import com.naever.store.infra.querydsl.QueryDslSupport

class ProductRepositoryImpl(
    private val productJpaRepository: ProductJpaRepository
) : IProductRepository, QueryDslSupport() {
}