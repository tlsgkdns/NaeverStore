package com.naever.store.domain.review.dto

data class UpdateReviewRequest(
    val rating : Int,
    val content : String,
)
