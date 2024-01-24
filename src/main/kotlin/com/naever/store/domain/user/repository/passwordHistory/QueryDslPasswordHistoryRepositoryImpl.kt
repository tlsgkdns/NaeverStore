package com.naever.store.domain.user.repository.passwordHistory

import com.naever.store.domain.user.model.PasswordHistory
import com.naever.store.domain.user.model.QPasswordHistory
import com.naever.store.infra.querydsl.QueryDslSupport
import com.querydsl.core.types.Order

class QueryDslPasswordHistoryRepositoryImpl: QueryDslPasswordHistoryRepository, QueryDslSupport() {
    private val passwordHistory = QPasswordHistory.passwordHistory
    override fun getPasswordHistory(userId: Long): List<String> {
        return queryFactory.selectFrom(passwordHistory)
            .where(passwordHistory.user.id.eq(userId))
            .offset(0)
            .limit(3)
            .orderBy(passwordHistory.createdAt.desc())
            .fetch()
            .map { it.password }
    }

}