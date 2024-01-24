package com.naever.store.domain.user.dto

import com.naever.store.domain.user.model.User
import org.springframework.security.crypto.password.PasswordEncoder


data class UserRegisterRequest(
    val email: String,
    val address: String,
    val password: String,
    val passwordConfirm: String,
    val nickname: String,
    val introduction: String
)
{
    fun to(passwordEncoder: PasswordEncoder): User
    {
        return User(
            email = email,
            address = address,
            nickname = nickname,
            introduction = introduction,
            password = passwordEncoder.encode(password)
        )
    }
}
