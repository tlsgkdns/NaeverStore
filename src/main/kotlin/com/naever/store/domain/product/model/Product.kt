package com.naever.store.domain.product.model

import com.naever.store.common.BaseTimeEntity
import com.naever.store.domain.product.dto.ProductRequest
import com.naever.store.domain.store.model.Store
import jakarta.persistence.*
import org.hibernate.annotations.SQLRestriction

@Entity
@Table(name = "product")
@SQLRestriction("is_deleted <> true")
class Product(

    @Column(name = "item_name")
    var itemName: String,

    @Column(name = "availability")
    var availability: Boolean = true,

    @Column(name = "quantity")
    var quantity: Int,

    @Column(name = "price")
    var price: Int,

    @Column(name = "sales")
    var sales: Int = 0,

    @Column(name = "description")
    var description: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    val store: Store

) : BaseTimeEntity() {
    init {
        if (quantity < 1) {
            throw IllegalArgumentException("quantity must be at least 1")
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun matchStoreId(requestStoreId: Long): Boolean {
        return store.id == requestStoreId
    }

    fun updateProduct(request: ProductRequest) {
        itemName = request.itemName
        price = request.price
        description = request.description
        quantity = request.quantity
    }

    fun deleteProduct() {
        isDeleted = true
    }

}