package com.naever.store.domain.review.service

import com.naever.store.domain.review.dto.CreateReviewRequest
import com.naever.store.domain.review.dto.ReviewResponse
import com.naever.store.domain.review.dto.UpdateReviewRequest

interface ReviewService {
    fun getAllReviewList(orderItemId: Long): List<ReviewResponse>

    fun createReview(orderItemId: Long, request: CreateReviewRequest): ReviewResponse

    fun updateReview(orderItemId: Long, reviewId: Long, request: UpdateReviewRequest): ReviewResponse

    fun deleteReview(orderItemId: Long, reviewId: Long)
}