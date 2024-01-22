package com.naever.store.domain.review.dto

data class CreateRatingRequest(
    val rating : String,
    val content : String,
)
