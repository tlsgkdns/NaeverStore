package com.naever.store.domain.user.dto

import org.hibernate.validator.constraints.Length

data class UserPasswordUpdateRequest(
    val passwordConfirm: String,
    val newPassword: String
)