package com.naever.store.domain.order.repository

import com.naever.store.domain.order.model.Order
import com.naever.store.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface OrderRepository: JpaRepository<Order, Long> {
    fun findByUser(user: User): List<Order>

    @Modifying
    @Query("select o from Order o left join OrderStore s on o.id = s.order.id left join User u on o.user.id = u.id where s.store.id = :storeId")
    fun findByStoreId(storeId: Long): List<Order>
}