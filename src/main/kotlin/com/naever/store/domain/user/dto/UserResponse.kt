package com.naever.store.domain.user.dto

import com.naever.store.domain.user.model.User
import com.naever.store.domain.user.model.UserType

data class UserResponse(
    val email: String,
    val nickname: String,
    val address: String,
    val introduction: String,
    val authority: UserType
)
{
    companion object
    {
        fun from(user: User): UserResponse
        {
            return UserResponse(
                user.email,
                user.nickname,
                user.address,
                user.introduction,
                user.authority
            )
        }
    }
}