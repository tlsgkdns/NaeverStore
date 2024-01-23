package com.naever.store.domain.order.dto

import com.naever.store.domain.order.model.Order
import java.time.ZonedDateTime

data class OrderDetailResponse( // 주문한 후 보여줄 DTO
    val id: Long?, // 주문번호
    val createdAt: ZonedDateTime, // 주문일자
    val status: String, // 주문상태 (결제완료, 주문취소, 배송준비중, 배송중, 배송완료)
    val address: String, // 배송 주소
    val products: List<SelectItemResponse>, // 주문한 상품(상품, 수량, 가격) 목록
) {
    companion object {
        fun fromEntity(orderItem: Order): OrderDetailResponse {
            return OrderDetailResponse(
                id = orderItem.id,
                createdAt = orderItem.createdAt,
                status = orderItem.status,
                address = orderItem.address,
                products = orderItem.orderItems.map { SelectItemResponse.fromEntity(it) }
            )
        }
    }
}
