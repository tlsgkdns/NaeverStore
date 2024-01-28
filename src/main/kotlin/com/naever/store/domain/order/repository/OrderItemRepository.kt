package com.naever.store.domain.order.repository

import com.naever.store.domain.order.model.OrderItem
import com.naever.store.domain.order.model.OrderStore
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface OrderItemRepository: JpaRepository<OrderItem, Long> {
    fun findByOrderStore(orderStore: OrderStore): List<OrderItem>

    @Modifying
    @Query("select i from OrderItem i left join OrderStore s on i.orderStore.id = s.id where s.order.id = :orderId and s.store.id = :storeId")
    fun findByOrderIdAndStoreId(orderId: Long, storeId: Long): List<OrderItem>
}