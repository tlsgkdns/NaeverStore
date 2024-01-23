package com.naever.store.domain.product.repository

class ProductRepositoryImpl(
    private val productJpaRepository: ProductJpaRepository
) : IProductRepository {
}