package com.example.facturasapi.repository

import com.example.facturasapi.model.Detail
import com.example.facturasapi.model.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository:JpaRepository<Invoice, Long> {

    @Query(nativeQuery = true)
    fun findTotalMoreThan(@Param("total") total: Double?):List<Invoice>?
    fun findById (id: Long?): Invoice
}