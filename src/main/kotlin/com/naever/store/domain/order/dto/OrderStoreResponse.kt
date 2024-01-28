package com.naever.store.domain.order.dto

import com.naever.store.domain.store.dto.StoreResponse

data class OrderStoreResponse(
    val store: StoreResponse,
    val orderItems: List<OrderItemResponse> // 주문한 상품(상품, 수량, 가격) 목록
)
