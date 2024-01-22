package com.naever.store.domain.order.model

import com.naever.store.common.BaseTimeEntity
import com.naever.store.domain.user.model.User
import jakarta.persistence.*

@Entity
@Table(name = "order")
class Order(

    @Column(name = "status")
    var status: Boolean,

    @Column(name = "address")
    var address: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User

) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}