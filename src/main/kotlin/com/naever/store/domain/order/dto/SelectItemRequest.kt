package com.naever.store.domain.order.dto

import com.naever.store.domain.product.model.Product

data class SelectItemRequest(
    val selectedItem: Product,
    val quantity: Long,
)
