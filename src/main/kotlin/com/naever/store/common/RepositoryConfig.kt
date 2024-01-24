package com.naever.store.common

import com.naever.store.domain.product.repository.IProductRepository
import com.naever.store.domain.product.repository.ProductJpaRepository
import com.naever.store.domain.product.repository.ProductRepositoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RepositoryConfig {

    @Bean
    fun productRepository(productJpaRepository: ProductJpaRepository): IProductRepository {
        return ProductRepositoryImpl(productJpaRepository)
    }
}