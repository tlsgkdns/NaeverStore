package com.naever.store.domain.review.dto

import org.hibernate.annotations.CreationTimestamp

data class ReviewResponse(
    val ratingId : Long,
    val rating : String,
    val content : String,
    val createdAt : CreationTimestamp
)
