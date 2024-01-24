package com.naever.store.domain.product.repository

import com.naever.store.domain.product.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductJpaRepository: JpaRepository<Product, Long> {
}