package com.naever.store.domain.product.controller

import com.naever.store.domain.product.dto.ProductPageRequest
import com.naever.store.domain.product.dto.ProductPageResponse
import com.naever.store.domain.product.dto.ProductRequest
import com.naever.store.domain.product.dto.ProductResponse
import com.naever.store.domain.product.service.ProductService
import com.naever.store.infra.security.UserPrincipal
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping
    fun registerProduct(
        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        @RequestBody request: ProductRequest
    ): ResponseEntity<ProductResponse> {

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(productService.registerProduct(userPrincipal.id, request))
    }

    @GetMapping
    fun getProductList(
        @RequestParam(defaultValue = "1") pageNumber: Int,
        @RequestParam(defaultValue = "5") pageSize: Int,
        request: ProductPageRequest
    ): ResponseEntity<ProductPageResponse> {

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(productService.getProductList(pageNumber, pageSize, request))
    }

    @GetMapping("/{productId}")
    fun getProductById(@PathVariable productId: Long): ResponseEntity<ProductResponse> {

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(productService.getProductById(productId))
    }

    @PutMapping("/{productId}")
    fun updateProduct(
        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        @PathVariable productId: Long,
        @RequestBody request: ProductRequest
    ): ResponseEntity<ProductResponse> {

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(productService.updateProduct(userPrincipal.id, productId, request))
    }

    @DeleteMapping("/{productId}")
    fun deleteProduct(
        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        @PathVariable productId: Long
    ): ResponseEntity<Unit> {

        productService.deleteProduct(userPrincipal.id, productId)

        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

}