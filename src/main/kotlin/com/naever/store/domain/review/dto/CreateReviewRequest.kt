package com.naever.store.domain.review.dto

data class CreateReviewRequest(
    val rating : Int,
    val content : String,
)
