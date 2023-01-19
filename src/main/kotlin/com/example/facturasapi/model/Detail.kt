package com.example.facturasapi.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "detail")

class Detail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var quantity: Long? = null
    @Column(name="invoice_id")
    var invoiceId: Long? = null
    @Column(name="product_id")
    var productId: Long? = null
}