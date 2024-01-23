package com.naever.store.domain.order.model

import com.naever.store.common.BaseTimeEntity
import com.naever.store.domain.product.model.Product
import jakarta.persistence.*

@Entity
@Table(name = "order_item") // 주문할 제품을 고르는 Entity입니다.
class OrderItem(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    val order: Order,

    // TODO : Product 브랜치와 합친 후에 주석 해제
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    val product: Product,

    @Column(name = "quantity")
    val quantity: Long,

    ) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
} // 아이템의 n개