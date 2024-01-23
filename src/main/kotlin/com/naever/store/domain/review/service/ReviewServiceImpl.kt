package com.naever.store.domain.review.service

import com.naever.store.domain.review.dto.CreateReviewRequest
import com.naever.store.domain.review.dto.ReviewResponse
import com.naever.store.domain.review.dto.UpdateReviewRequest
import org.springframework.transaction.annotation.Transactional

class ReviewServiceImpl(

) : ReviewService {

    override fun getAllReviewList(productId: Long): List<ReviewResponse>{
        TODO()
    }

    //@Transactional
    override fun createReview(productId: Long, request: CreateReviewRequest): ReviewResponse{
        TODO()
    }

    //@Transactional
    override fun updateReview(productId: Long, reviewId: Long, request: UpdateReviewRequest): ReviewResponse{
        TODO()
    }

    //@Transactional
    override fun deleteReview(productId: Long, reviewId: Long){
        TODO()
    }
}