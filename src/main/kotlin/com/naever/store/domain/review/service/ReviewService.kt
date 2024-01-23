package com.naever.store.domain.review.service

import com.naever.store.domain.review.dto.CreateReviewRequest
import com.naever.store.domain.review.dto.ReviewResponse
import com.naever.store.domain.review.dto.UpdateReviewRequest

interface ReviewService {
    fun getAllReviewList(productId: Long): List<ReviewResponse>

    fun createReview(productId: Long, request: CreateReviewRequest): ReviewResponse

    fun updateReview(productId: Long, reviewId: Long, request: UpdateReviewRequest): ReviewResponse

    fun deleteReview(productId: Long, reviewId: Long)
}