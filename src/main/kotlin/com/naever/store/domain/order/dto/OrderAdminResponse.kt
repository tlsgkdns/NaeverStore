package com.naever.store.domain.order.dto

import java.time.ZonedDateTime

data class OrderAdminResponse(
    val orderId: Long,
    val address: String,
    val orderedDate: ZonedDateTime,
    val userId: Long,
    val orderItems: List<OrderItemResponse>
)
