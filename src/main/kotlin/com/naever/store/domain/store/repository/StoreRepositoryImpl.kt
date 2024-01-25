package com.naever.store.domain.store.repository

import com.naever.store.domain.store.model.QStore
import com.naever.store.domain.store.model.Store
import com.naever.store.infra.querydsl.QueryDslSupport
import org.springframework.data.repository.findByIdOrNull

class StoreRepositoryImpl(
    private val storeJpaRepository: StoreJpaRepository
) : IStoreRepository, QueryDslSupport() {

    val store = QStore.store

    override fun save(store: Store): Store {
        return storeJpaRepository.save(store)
    }

    override fun findById(id: Long): Store? {
        return storeJpaRepository.findByIdOrNull(id)
    }

    override fun findByUserId(userId: Long): Store? {
        return queryFactory.select(store)
            .where(store.user.id.eq(userId))
            .fetchOne()
    }

}