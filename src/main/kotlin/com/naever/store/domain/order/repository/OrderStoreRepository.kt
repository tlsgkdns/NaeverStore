package com.naever.store.domain.order.repository

import com.naever.store.domain.order.model.Order
import com.naever.store.domain.order.model.OrderStore
import org.springframework.data.jpa.repository.JpaRepository

interface OrderStoreRepository : JpaRepository<OrderStore, Long> {

    fun findByOrder(order: Order): List<OrderStore>
}