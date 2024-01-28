package com.naever.store.domain.order.dto

import com.naever.store.domain.order.model.OrderItem
import com.naever.store.domain.product.dto.ProductResponse

data class OrderItemResponse(
    val id: Long,
    val product: ProductResponse,
    val quantity: Int,
) {
    companion object {
        fun fromEntity(orderItem: OrderItem): OrderItemResponse {
            return OrderItemResponse(
                id = orderItem.id!!,
                product = ProductResponse.from(orderItem.product),
                quantity = orderItem.quantity
            )
        }
    }
}
