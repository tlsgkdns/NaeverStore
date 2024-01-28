package com.naever.store.domain.order.model

import com.naever.store.common.BaseTimeEntity
import com.naever.store.domain.product.model.Product
import com.naever.store.domain.review.model.Review
import jakarta.persistence.*

@Entity
@Table(name = "order_item")
class OrderItem(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    val product: Product,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_store_id")
    val orderStore: OrderStore,

    @Column(name = "quantity")
    val quantity: Int,

    @OneToMany( cascade = [CascadeType.ALL], orphanRemoval = true,fetch = FetchType.LAZY)
    var reviews: MutableList<Review> = mutableListOf(),

    ) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

} // 아이템의 n개