package com.naever.store.domain.user.dto

data class UserUpdateRequest (
    val nickname: String?,
    val address: String?,
    val introduction: String?,
    val email: String?
)