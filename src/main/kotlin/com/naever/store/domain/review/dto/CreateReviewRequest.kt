package com.naever.store.domain.review.dto

data class CreateReviewRequest(
    val rating : String,
    val content : String,
)
