package com.naever.store.domain.review.dto

data class UpdateReviewRequest(
    val rating : String,
    val content : String,
)
