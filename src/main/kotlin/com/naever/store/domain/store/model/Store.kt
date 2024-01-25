package com.naever.store.domain.store.model

import com.naever.store.common.BaseTimeEntity
import com.naever.store.domain.store.dto.StoreRequest
import com.naever.store.domain.user.model.User
import jakarta.persistence.*

@Entity
@Table(name = "store")
class Store(

    @Column(name = "name")
    var name: String,

    @Column(name = "introduction")
    var introduction: String,

    @OneToOne
    @JoinColumn(name = "user_id")
    var user: User

): BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun matchUserId(requestUserId: Long): Boolean {
        return user.id == requestUserId
    }

    fun update(request: StoreRequest) {
        name = request.name
        introduction = request.introduction
    }

}