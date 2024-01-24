package com.naever.store.domain.order.dto

import com.naever.store.domain.order.model.OrderItem
import com.naever.store.domain.product.dto.ProductResponse

data class OrderItemResponse( // 사용자가 고른 제품들 보여줄 DTO
    val product: ProductResponse, // 고른 제품
    val quantity: Int, // 고른 수량
) {
    companion object {
        fun fromEntity(orderItem: OrderItem): OrderItemResponse {
            return OrderItemResponse(
                product = ProductResponse.from(orderItem.product),
                quantity = orderItem.quantity
            )
        }
    }
}
