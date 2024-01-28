package com.naever.store.domain.order.repository

import com.naever.store.domain.order.model.OrderItem
import com.naever.store.domain.order.model.OrderStore
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository: JpaRepository<OrderItem, Long> {
    fun findByOrderStore(orderStore: OrderStore): List<OrderItem>
}