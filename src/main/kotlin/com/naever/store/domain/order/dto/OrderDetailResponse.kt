package com.naever.store.domain.order.dto

data class OrderDetailResponse( // 주문한 후 보여줄 DTO
    val order: OrderResponse,
    val orderStores: List<OrderStoreResponse>   // 주문한 상점 목록
)
