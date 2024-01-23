package com.naever.store.domain.review.model

import com.naever.store.common.BaseTimeEntity
import com.naever.store.domain.product.model.Product
import com.naever.store.domain.review.dto.ReviewResponse
import com.naever.store.domain.user.model.User
import jakarta.persistence.*

@Entity
@Table(name = "review")
class Review (

        @Column(name = "rating",nullable = false)
        val rating : String,

        @Column(name = "content")
        val content : String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "product_id")
        val product : Product,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        val user : User

): BaseTimeEntity()
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
}

fun Review.toResponse(): ReviewResponse {
        return ReviewResponse(
                ratingId = id!!,
                rating = rating,
                content = content,
                createdAt = createdAt,
        )
}