package com.naever.store.domain.product.service

import com.naever.store.domain.product.dto.ProductRequest
import com.naever.store.domain.product.dto.ProductResponse
import com.naever.store.domain.product.model.Product
import com.naever.store.domain.product.repository.IProductRepository
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: IProductRepository
) : ProductService {

    override fun registerProduct(request: ProductRequest): ProductResponse {
        // TODO : controller 에서 user id 받아서 user 있는지 확인

        return Product(
            itemName = request.itemName,
            price = request.price,
            quantity = request.quantity,
            description = request.description,
            // TODO : user 넣기
        ).let {
            productRepository.save(it)
        }.let {
            ProductResponse.from(it) }
    }

}