package com.naever.store.domain.review.service

import com.naever.store.domain.exception.ModelNotFoundException
import com.naever.store.domain.order.repository.OrderItemRepository
import com.naever.store.domain.review.dto.CreateReviewRequest
import com.naever.store.domain.review.dto.ReviewResponse
import com.naever.store.domain.review.dto.UpdateReviewRequest
import com.naever.store.domain.review.model.Review
import com.naever.store.domain.review.repositiory.ReviewRepository
import com.naever.store.domain.user.model.QUser.user
import com.naever.store.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ReviewServiceImpl(
    private val reviewRepository: ReviewRepository,
    private val orderItemRepository: OrderItemRepository,
    private val userRepository: UserRepository
) : ReviewService {

    override fun getAllReviewList(orderItemId: Long): List<ReviewResponse>{
        TODO()
    }

    override fun createReview(orderItemId: Long, request: CreateReviewRequest): ReviewResponse{
        TODO()

    }

    override fun updateReview(orderItemId: Long, reviewId: Long, request: UpdateReviewRequest): ReviewResponse{
        TODO()
    }

    override fun deleteReview(orderItemId: Long, reviewId: Long){
        TODO()
    }
}