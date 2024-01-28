package com.naever.store.domain.store.repository

import com.naever.store.domain.store.model.QStore
import com.naever.store.domain.store.model.Store
import com.naever.store.domain.user.model.QUser
import com.naever.store.infra.querydsl.QueryDslSupport

class StoreRepositoryImpl(
    private val storeJpaRepository: StoreJpaRepository
) : IStoreRepository, QueryDslSupport() {

    private val store = QStore.store
    private val user = QUser.user

    override fun save(store: Store): Store {
        return storeJpaRepository.save(store)
    }

    override fun findById(id: Long): Store? {
        return queryFactory.select(store)
            .from(store)
            .leftJoin(store.user, user).fetchJoin()
            .where(store.id.eq(id))
            .fetchOne()
    }

    override fun existsByUserId(userId: Long): Boolean {
        return storeJpaRepository.existsByUserId(userId)
    }

}