package com.naever.store.domain.user.controller

import com.naever.store.domain.user.dto.*
import com.naever.store.domain.user.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    @PostMapping()
    fun signUp(@RequestBody @Valid userRegisterRequest: UserRegisterRequest,
        bindingResult: BindingResult): ResponseEntity<UserResponse>
    {
        if(bindingResult.hasErrors())
            throw IllegalArgumentException(bindingResult.fieldError?.defaultMessage ?: "")
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(userService.registerUser(userRegisterRequest))
    }
    @PostMapping("/login")
    fun login(@RequestBody userLoginDTO: UserLoginRequest): ResponseEntity<UserLoginResponse>
    {
        return ResponseEntity.status(HttpStatus.OK)
            .body(userService.loginUser(userLoginDTO))
    }
    @PreAuthorize("hasAuthority('ROLE_USER') && authentication?.principal?.id == #userId")
    @PutMapping("/{userId}")
    fun updateUser(@PathVariable userId: Long, @Valid updateRequest: UserUpdateRequest
                   , bindingResult: BindingResult)
    : ResponseEntity<UserResponse>
    {
        if(bindingResult.hasErrors())
            throw IllegalArgumentException(bindingResult.fieldError?.defaultMessage ?: "")
        return ResponseEntity.status(HttpStatus.OK)
            .body(userService.updateUser(userId, updateRequest))
    }
    @PreAuthorize("hasAuthority('ROLE_USER') && authentication?.principal?.id == #userId")
    @PatchMapping("/{userId}")
    fun updatePassword(@PathVariable userId: Long,
                       @RequestBody @Valid userPasswordUpdateDTO: UserPasswordUpdateRequest,
                       bindingResult: BindingResult): ResponseEntity<UserResponse>
    {
        if(bindingResult.hasErrors())
            throw IllegalArgumentException(bindingResult.fieldError?.defaultMessage ?: "")
        return ResponseEntity.status(HttpStatus.OK)
            .body(userService.updatePassword(userId, userPasswordUpdateDTO))
    }
}