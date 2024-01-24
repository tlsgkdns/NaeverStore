package com.naever.store.domain.user.dto

import com.naever.store.domain.user.model.User
import com.naever.store.domain.user.model.UserType

data class UserResponse(
    val id: Long,
    val email: String,
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
                user.id!!,
                user.email,
                user.address,
                user.introduction,
                user.authority
            )
        }
    }
}