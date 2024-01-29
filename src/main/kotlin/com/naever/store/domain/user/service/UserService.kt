package com.naever.store.domain.user.service

import com.naever.store.domain.user.dto.*

interface UserService {
    fun registerUser(userRegisterRequest: UserRegisterRequest): UserResponse
    fun loginUser(loginRequest: UserLoginRequest): UserLoginResponse
    fun updateUser(userId: Long, updateRequest: UserUpdateRequest): UserResponse
    fun updatePassword(userId: Long, userPasswordUpdateRequest: UserPasswordUpdateRequest): UserResponse

    fun getUser(userId: Long): UserResponse
}