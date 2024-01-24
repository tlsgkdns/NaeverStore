package com.naever.store.domain.cart.model

import com.naever.store.domain.product.model.Product
import com.naever.store.domain.user.model.User
import jakarta.persistence.*

@Entity
@Table(name = "cart")
data class Cart (
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    val product: Product,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,
    var quantity: Int = 1
)
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}