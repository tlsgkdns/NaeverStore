package com.naever.store.domain.user.dto

data class UserLoginRequest(
    val email: String,
    val password: String
)
