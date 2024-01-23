package com.naever.store.domain.order.dto

import com.naever.store.domain.order.model.OrderItem
import com.naever.store.domain.product.model.Product

// TODO : Product 브랜치와 합친 후에 주석 해제
data class OrderItemResponse( // 사용자가 고른 제품들 보여줄 DTO
//    val product: Product, // 고른 제품
    val quantity: Long, // 고른 수량
) {
    companion object {
        fun fromEntity(orderItem: OrderItem): OrderItemResponse {
            return OrderItemResponse(
//                product = ProductResponse.from(orderItem.product)
                quantity = orderItem.quantity
            )
        }
    }
}
