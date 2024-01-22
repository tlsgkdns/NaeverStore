package com.naever.store.domain.review.dto

import java.time.LocalDateTime

data class RatingResponse(
    val ratingId : Long,
    val rating : String,
    val content : String,
    val createdAt : LocalDateTime
)
