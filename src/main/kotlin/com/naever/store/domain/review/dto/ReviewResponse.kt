package com.naever.store.domain.review.dto

import org.hibernate.annotations.CreationTimestamp
import java.time.ZonedDateTime

data class ReviewResponse(
    val ratingId : Long,
    val rating : String,
    val content : String,
    val createdAt : ZonedDateTime//CreationTimestamp
)
