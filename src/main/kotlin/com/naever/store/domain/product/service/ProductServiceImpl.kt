package com.naever.store.domain.product.service

import com.naever.store.domain.exception.ForbiddenException
import com.naever.store.domain.exception.ModelNotFoundException
import com.naever.store.domain.product.dto.ProductPageRequest
import com.naever.store.domain.product.dto.ProductPageResponse
import com.naever.store.domain.product.dto.ProductRequest
import com.naever.store.domain.product.dto.ProductResponse
import com.naever.store.domain.product.model.Product
import com.naever.store.domain.product.repository.IProductRepository
import com.naever.store.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: IProductRepository, private val userRepository: UserRepository
) : ProductService {

    override fun registerProduct(userId: Long, request: ProductRequest): ProductResponse {

        val user = userRepository.findByIdOrNull(userId) ?: throw ModelNotFoundException("User", userId)

        return Product(
            itemName = request.itemName,
            price = request.price,
            stock = request.stock,
            description = request.description,
            user = user
        ).let {
            productRepository.save(it)
        }.let { ProductResponse.from(it) }
    }

    override fun getProductList(pageNumber: Int, pageSize: Int, request: ProductPageRequest): ProductPageResponse {

        return productRepository.getPaginatedProductList(pageNumber, pageSize, request)
    }

    override fun getProductById(productId: Long): ProductResponse {

        val product = productRepository.findProductById(productId) ?: throw ModelNotFoundException("Product", productId)

        return ProductResponse.from(product)
    }

    override fun updateProduct(userId: Long, productId: Long, request: ProductRequest): ProductResponse {

        val product = getProductIfAuthorized(userId, productId)

        product.updateProduct(request)

        return productRepository.save(product)
            .let { ProductResponse.from(it) }
    }

    override fun deleteProduct(userId: Long, productId: Long) {

        val product = getProductIfAuthorized(userId, productId)

        productRepository.deleteProductById(product.id!!)
    }

    private fun getProductIfAuthorized(userId: Long, productId: Long): Product {

        if (!userRepository.existsById(userId)) {
            throw ModelNotFoundException("User", userId)
        }

        val product = productRepository.findProductById(productId) ?: throw ModelNotFoundException("Product", productId)

        if (!product.matchUserId(userId)) {
            throw ForbiddenException(userId, "Product", productId)
        }

        return product
    }

}