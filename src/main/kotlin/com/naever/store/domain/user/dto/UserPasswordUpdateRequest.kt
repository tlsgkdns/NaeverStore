package com.naever.store.domain.user.dto

data class UserPasswordUpdateRequest(
    val passwordConfirm: String,
    val newPassword: String
)