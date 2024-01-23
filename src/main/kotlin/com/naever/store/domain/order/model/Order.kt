package com.naever.store.domain.order.model

import com.naever.store.common.BaseTimeEntity
import com.naever.store.domain.user.model.User
import jakarta.persistence.*

@Entity
@Table(name = "order_history") // 주문을 생성, 조회, 수정, 삭제할 때의 Entity입니다.
class Order(
    @Column
    var address: String,

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")
//    val orderItems: List<OrderItem> = mutableListOf(),

    // TODO: User 브랜치와 합친 후에 주석 해제
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    val user: User,

    @Column
    // TODO : enum 을 만들어서 ORDERED, CANCELLED, DELIVERED 등을 넣어주면 좋을 것 같습니다ㅎㅎ
    var status: String = "ORDERED",


    ) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}