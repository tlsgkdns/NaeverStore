package com.naever.store.domain.order.dto

import com.naever.store.domain.order.model.OrderStatus
import java.time.ZonedDateTime

data class OrderAdminResponse(
    val orderId: Long,
    val address: String,
    val orderedDate: ZonedDateTime,
    val status: OrderStatus,
    val userId: Long,
    val orderItems: List<OrderItemResponse>
)
