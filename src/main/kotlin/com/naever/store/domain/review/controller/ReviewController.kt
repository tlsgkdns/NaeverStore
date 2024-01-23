package com.naever.store.domain.review.controller

import com.naever.store.domain.review.dto.CreateReviewRequest
import com.naever.store.domain.review.dto.ReviewResponse
import com.naever.store.domain.review.dto.UpdateReviewRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/products/{productId}/reviews")
@RestController
class ReviewController {

    @GetMapping
    fun getReviewList(@PathVariable productId: Long
    ): ResponseEntity<List<ReviewResponse>> {
       TODO()
    }

    @PutMapping("/{reviewId}")
    fun updateReview(
        @PathVariable productId: Long,
        @PathVariable reviewId: Long,
        @RequestBody updateCommentRequest: UpdateReviewRequest
    ): ResponseEntity<ReviewResponse> {
        TODO()
    }

    @PostMapping
    fun createReview(
        @PathVariable productId: Long,
        @RequestBody createCommentRequest: CreateReviewRequest
    ): ResponseEntity<ReviewResponse> {
        TODO()
    }

    @DeleteMapping("/{reviewId}")
    fun deleteReview(
        @PathVariable productId: Long,
        @PathVariable reviewId: Long
    ): ResponseEntity<Unit> {
       TODO()
    }

}