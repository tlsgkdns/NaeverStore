package com.naever.store.domain.user.repository.passwordHistory

interface QueryDslPasswordHistoryRepository {
    fun getPasswordHistory(userId: Long): List<String>
}