package com.naever.store.domain.product.dto

import com.naever.store.domain.product.model.Product

data class ProductResponse(
    val id: Long?,
    val itemName: String,
    val price: Int,
    val description: String,
    val quantity: Int,
    val sales: Int,
    val availability: Boolean,
    val userId: Long?,
) {
    companion object {
        fun from(product: Product) : ProductResponse {
            return ProductResponse(
                id = product.id,
                itemName = product.itemName,
                price = product.price,
                description = product.description,
                quantity = product.quantity,
                sales = product.sales,
                availability = product.availability,
                userId = product.user.id
            )
        }
    }
}
