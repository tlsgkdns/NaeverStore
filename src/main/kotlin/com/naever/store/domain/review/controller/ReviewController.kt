package com.naever.store.domain.review.controller

import com.naever.store.domain.review.dto.CreateReviewRequest
import com.naever.store.domain.review.dto.ReviewResponse
import com.naever.store.domain.review.dto.UpdateReviewRequest
import com.naever.store.domain.review.service.ReviewService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/orderItems/{orderItemId}/reviews")
@RestController
class ReviewController(
    private val reviewService: ReviewService
) {

    @GetMapping
    fun getReviewList(@PathVariable orderItemId: Long
    ): ResponseEntity<ReviewResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(reviewService.getAllReviewList(orderItemId))
    }

    @PutMapping("/{reviewId}")
    fun updateReview(
        @PathVariable orderItemId: Long,
        @PathVariable reviewId: Long,
        @RequestBody updateReviewRequest: UpdateReviewRequest
    ): ResponseEntity<ReviewResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(reviewService.updateReview(orderItemId, reviewId, updateReviewRequest))

    }

    @PostMapping
    fun createReview(
        @PathVariable orderItemId: Long,
        @RequestBody createReviewRequest: CreateReviewRequest
    ): ResponseEntity<ReviewResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(reviewService.createReview(orderItemId , createReviewRequest))
    }

    @DeleteMapping("/{reviewId}")
    fun deleteReview(
        @PathVariable orderItemId: Long,
        @PathVariable reviewId: Long
    ): ResponseEntity<Unit> {
        reviewService.deleteReview(orderItemId, reviewId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

}