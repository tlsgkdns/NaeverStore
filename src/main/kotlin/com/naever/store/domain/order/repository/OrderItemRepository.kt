package com.naever.store.domain.order.repository

import com.naever.store.domain.order.model.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository: JpaRepository<Order, Long> {
}