package com.naever.store.domain.product.repository

import com.naever.store.domain.product.model.Product

interface IProductRepository {

    fun save(product: Product): Product
}