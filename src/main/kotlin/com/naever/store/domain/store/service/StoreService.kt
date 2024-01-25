package com.naever.store.domain.store.service

import com.naever.store.domain.store.dto.StoreRequest
import com.naever.store.domain.store.dto.StoreResponse

interface StoreService {

    fun createStore(request: StoreRequest): StoreResponse
}