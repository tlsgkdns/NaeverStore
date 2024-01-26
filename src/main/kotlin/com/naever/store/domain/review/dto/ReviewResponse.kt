package com.naever.store.domain.review.dto

import com.naever.store.domain.review.model.Review
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import java.time.ZonedDateTime

data class ReviewResponse(
    val id: Long?,
    val rating: Int,
    val content: String,
    val createdAt: ZonedDateTime
)
{
    companion object {
       fun from(review: Review) : ReviewResponse{
           return ReviewResponse(
               id = review.id !!,
               rating = review.rating,
               content = review.content,
               createdAt = review.createdAt
           )
       }
    }
}
