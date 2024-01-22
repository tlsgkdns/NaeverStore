package com.naever.store.domain.product.model

import jakarta.persistence.*

@Entity
@Table(name = "product")
class Product(

    @Column(name = "item_name")
    var itemName: String,

    @Column(name = "availability")
    var availability: Boolean,

    @Column(name = "quantity")
    val quantity: Int,

    @Column(name = "price")
    var price: Int,

    @Column(name = "sale")
    var sale: Int,

    @Column(name = "description")
    var description: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}