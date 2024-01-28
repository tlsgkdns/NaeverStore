package com.naever.store.domain.order.model

import com.naever.store.domain.store.model.Store
import jakarta.persistence.*

@Entity
@Table(name = "order_store")
class OrderStore(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    val order: Order,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    val store: Store

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}