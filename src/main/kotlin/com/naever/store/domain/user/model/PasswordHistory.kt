package com.naever.store.domain.user.model

import com.naever.store.common.BaseTimeEntity
import jakarta.persistence.*
import org.springframework.web.bind.annotation.GetMapping

@Entity
@Table(name = "password_history")
data class PasswordHistory(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,
    @Column(name = "password")
    val password: String
): BaseTimeEntity()
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null
}
