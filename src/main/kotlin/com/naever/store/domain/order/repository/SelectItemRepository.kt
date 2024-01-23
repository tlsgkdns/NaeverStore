package com.naever.store.domain.order.repository

import com.naever.store.domain.order.model.SelectItem
import org.springframework.data.jpa.repository.JpaRepository

interface SelectItemRepository: JpaRepository<SelectItem, Long> {
}