package com.naever.store.domain.order.dto

import com.naever.store.domain.order.model.SelectItem
import com.naever.store.domain.product.model.Product

data class SelectItemResponse( // 사용자가 고른 제품들 보여줄 DTO
    val selectedItem: Product, // 고른 제품
    val quantity: Long, // 고른 수량
) {
    companion object {
        fun fromEntity(order: SelectItem): SelectItemResponse {
            return SelectItemResponse(
                selectedItem = order.selectedItem.id!!,
                quantity = order.quantity,
            )
        }
    }
}
