package com.example.facturasapi.service

import com.example.facturasapi.model.Product
import com.example.facturasapi.repository.ProductRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceSave {
    @InjectMocks
    lateinit var productService: ProductService

    @Mock
    lateinit var productRepository: ProductRepository

    val productMock = Product().apply {
        id= 1
        description= "1"
        brand= "Manzana"
        stock = 1

    }

    @Test
    fun saveProductCorrect(){
        Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
        val response = productService.save(productMock)
        Assertions.assertEquals(response.id, productMock.id)
    }


    @Test
    fun saveProductWhenDescriptionIsBlank(){

        Assertions.assertThrows(Exception::class.java) {
            productMock.apply { description=" "}
            Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
            productService.save(productMock)
        }

    }


    @Test
    fun saveProductWhenStockIsBlank(){

        Assertions.assertThrows(Exception::class.java) {
            productMock.apply { stock= 0 }
            Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
            productService.save(productMock)
        }

    }
}