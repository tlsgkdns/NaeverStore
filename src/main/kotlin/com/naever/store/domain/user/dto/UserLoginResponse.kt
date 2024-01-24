package com.naever.store.domain.user.dto

import com.naever.store.domain.user.model.UserType

data class UserLoginResponse(
    val email: String,
    val type: UserType,
    val token: String
)