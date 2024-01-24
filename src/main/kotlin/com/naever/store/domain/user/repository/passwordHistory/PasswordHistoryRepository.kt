package com.naever.store.domain.user.repository.passwordHistory

import com.naever.store.domain.user.model.PasswordHistory
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PasswordHistoryRepository: JpaRepository<PasswordHistory, Long>, QueryDslPasswordHistoryRepository {
}