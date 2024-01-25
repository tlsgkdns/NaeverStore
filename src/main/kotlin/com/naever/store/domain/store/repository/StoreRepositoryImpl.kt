package com.naever.store.domain.store.repository

import com.naever.store.domain.store.model.Store
import com.naever.store.infra.querydsl.QueryDslSupport

class StoreRepositoryImpl(
    private val storeJpaRepository: StoreJpaRepository
) : IStoreRepository, QueryDslSupport() {

    override fun save(store: Store): Store {
        return storeJpaRepository.save(store)
    }

}