package com.naever.store.domain.user.model

import com.naever.store.common.BaseTimeEntity
import jakarta.persistence.*

@Table(name = "app_user")
@Entity
data class User(
    @Column(name = "nickname")
    val nickname:String,
    @Column(name = "password")
    val password: String,
    @Column(name = "email")
    val email: String,
    @Column(name = "address")
    val address: String,
    @Column(name = "introduction")
    val introduction: String,
    @Column(name = "authority")
    @Enumerated(EnumType.STRING)
    val authority: UserType = UserType.USER
) : BaseTimeEntity()
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}