package com.naever.store.domain.store.controller

import com.naever.store.domain.store.dto.StoreRequest
import com.naever.store.domain.store.dto.StoreResponse
import com.naever.store.domain.store.service.StoreService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/stores")
class StoreController(
    private val storeService: StoreService
) {

    @PostMapping
    fun createStore(@RequestBody request: StoreRequest): ResponseEntity<StoreResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(storeService.createStore(request))
    }

    @GetMapping("/{storeId}")
    fun getStore(@PathVariable storeId: Long): ResponseEntity<StoreResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(storeService.getStore(storeId))
    }

    @PutMapping("/{storeId}")
    fun updateStore(@PathVariable storeId: Long, @RequestBody request: StoreRequest): ResponseEntity<StoreResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(storeService.updateStore(storeId, request))
    }

}
