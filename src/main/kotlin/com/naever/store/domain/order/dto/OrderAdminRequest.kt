package com.naever.store.domain.order.dto

data class OrderAdminRequest(
    val orderIds: List<Long>,
    val status: String
)
