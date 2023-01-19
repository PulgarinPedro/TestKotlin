package com.example.facturasapi.service

import com.example.facturasapi.model.Product
import com.example.facturasapi.repository.ProductRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProductService {



    @Autowired
    lateinit var productRepository: ProductRepository

    fun list():List<Product>{
        return productRepository.findAll()
    }
    fun listById (id: Long?): Product{
        return productRepository.findById(id)
    }


    fun save(product: Product): Product {
        try{
            product.description?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Descripción no debe ser vacio")
            product.stock?.takeIf { it > 0 }
                ?: throw Exception("Stock Prueba")

            return productRepository.save(product)
        } catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }


    }


    fun update(product:Product):   Product {
        try{
            productRepository.findById(product.id)
                ?: throw Exception("ID no existe")

            return productRepository.save(product)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


    fun updateStock(product: Product): Product {
        try{
            val response = productRepository.findById(product.id)
                ?: throw Exception("ID no existe")
            response.apply {
                stock =product.stock
            }
            return productRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


}




