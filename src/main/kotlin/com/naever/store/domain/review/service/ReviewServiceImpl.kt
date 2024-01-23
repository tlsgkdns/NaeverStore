package com.naever.store.domain.review.service

import com.naever.store.domain.review.dto.CreateReviewRequest
import com.naever.store.domain.review.dto.ReviewResponse
import com.naever.store.domain.review.dto.UpdateReviewRequest
import com.naever.store.domain.review.repositiory.ReviewRepository

class ReviewServiceImpl(
    private val reviewRepository: ReviewRepository
) : ReviewService {

    override fun getAllReviewList(productId: Long): List<ReviewResponse>{
        TODO()
    }

    override fun createReview(productId: Long, request: CreateReviewRequest): ReviewResponse{
        TODO()
    }

    override fun updateReview(productId: Long, reviewId: Long, request: UpdateReviewRequest): ReviewResponse{
        TODO()
    }

    override fun deleteReview(productId: Long, reviewId: Long){
        TODO()
    }
}