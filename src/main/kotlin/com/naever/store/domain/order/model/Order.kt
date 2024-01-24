package com.naever.store.domain.order.model

import com.naever.store.common.BaseTimeEntity
import com.naever.store.domain.user.model.User
import jakarta.persistence.*

@Entity
@Table(name = "order_history") // 주문을 생성, 조회, 수정, 삭제할 때의 Entity입니다.
class Order(
    @Column
    var address: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @Column
    @Enumerated(EnumType.STRING)
    var status: OrderStatus = OrderStatus.ORDERED,

    ) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}