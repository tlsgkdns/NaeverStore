package com.naever.store.domain.review.repositiory

import com.naever.store.domain.order.model.OrderItem
import com.naever.store.domain.review.model.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<Review, Long> {
    fun findByOrderItemIdAndId(orderItemId: Long , reviewId: Long): Review?

    fun findByOrderItemId(orderItemId:Long) : Review?
}