package com.naever.store.domain.order.controller

import com.naever.store.domain.order.dto.*
import com.naever.store.domain.order.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(private val orderItemService: OrderService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<OrderDetailResponse>> {
        val orders = orderItemService.findAll()
        return ResponseEntity.status(HttpStatus.OK).body(orderItemService.findAll())
    }

    @GetMapping("/{orderId}")
    fun findById(@PathVariable orderId: Long): ResponseEntity<OrderDetailResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(orderItemService.findById(orderId))
    }

//    @PostMapping("/selectItem")
//    fun selectItem(@RequestBody orderItemRequest: OrderItemRequest): ResponseEntity<SelectItemResponse> {
//        return ResponseEntity.status(HttpStatus.CREATED).body(orderItemService.selectItem(orderItemRequest))
//    }

    @PostMapping
    fun createOrder(@RequestBody orderRequest: CreateOrderRequest): ResponseEntity<OrderDetailResponse> {
        // TODO : Authentication 의 Principal 에서 user id 가져와서 orderRequest 에 넣어주기
        return ResponseEntity.status(HttpStatus.CREATED).body(orderItemService.createOrder(orderRequest))
    }

    @PutMapping("/{orderId}")
    fun updateOrder(@PathVariable orderId: Long, @RequestBody updateOrderRequest: UpdateOrderRequest): ResponseEntity<OrderDetailResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(orderItemService.updateOrder(orderId, updateOrderRequest))
    }

    @DeleteMapping("/{orderId}")
    fun deleteOrder(@PathVariable orderId: Long): ResponseEntity<Unit> {
        orderItemService.deleteOrder(orderId)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

}