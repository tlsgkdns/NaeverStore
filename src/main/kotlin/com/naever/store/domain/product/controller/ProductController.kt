package com.naever.store.domain.product.controller

import com.naever.store.domain.product.dto.ProductRequest
import com.naever.store.domain.product.dto.ProductResponse
import com.naever.store.domain.product.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping
    fun registerProduct(@RequestBody request: ProductRequest): ResponseEntity<ProductResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(productService.registerProduct(request))
    }

}