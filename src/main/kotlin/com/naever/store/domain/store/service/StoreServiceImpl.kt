package com.naever.store.domain.store.service

import com.naever.store.domain.exception.ModelNotFoundException
import com.naever.store.domain.store.dto.StoreRequest
import com.naever.store.domain.store.dto.StoreResponse
import com.naever.store.domain.store.model.Store
import com.naever.store.domain.store.repository.IStoreRepository
import com.naever.store.domain.user.repository.UserRepository
import com.naever.store.infra.security.SecurityUtil
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class StoreServiceImpl(
    private val userRepository: UserRepository,
    private val storeRepository: IStoreRepository
) : StoreService {

    override fun createStore(request: StoreRequest): StoreResponse {

        val user = userRepository.findByIdOrNull(SecurityUtil.getLoginUserId())
            ?: throw ModelNotFoundException("User", SecurityUtil.getLoginUserId())

        return Store(
            name = request.name,
            introduction = request.introduction,
            user = user
        ).let {
            storeRepository.save(it)
        }.let {
            StoreResponse.from(it)
        }
    }

}
