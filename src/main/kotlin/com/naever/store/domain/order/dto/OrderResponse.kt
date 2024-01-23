package com.naever.store.domain.order.dto

import com.naever.store.domain.order.model.Order
import java.time.ZonedDateTime

// TODO : User 브랜치와 합친 후에 주석 해제
data class OrderResponse(
    val id: Long?, // 주문번호
//    val userId: Long?,
    val createdAt: ZonedDateTime, // 주문일자
    val status: String, // 주문상태 (결제완료, 주문취소, 배송준비중, 배송중, 배송완료)
    val address: String, // 배송 주소
) {
    companion object {
        fun from(order: Order) : OrderResponse {
            return OrderResponse(
                id = order.id,
//                userId = order.user.id,
                createdAt = order.createdAt,
                status = order.status,
                address = order.address
            )
        }
    }
}
