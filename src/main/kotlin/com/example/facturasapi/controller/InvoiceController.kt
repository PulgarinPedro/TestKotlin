package com.example.facturasapi.controller

import com.example.facturasapi.model.Invoice
import com.example.facturasapi.service.InvoiceService
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/invoice")
class InvoiceController {

    @Autowired
    lateinit var  invoiceService: InvoiceService

    @GetMapping
    fun list():ResponseEntity<*>{
        return ResponseEntity(invoiceService.list(), HttpStatus.OK)
    }
    @GetMapping("/totals/{total}")
    fun listTotals (@PathVariable("total") total: Double ):ResponseEntity<*>{
        return ResponseEntity(invoiceService.listTotalMoreThan(total), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable ("id") id: Long):ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.listById(id), HttpStatus.OK)
    }
    @PostMapping
    fun save(@RequestBody @Valid invoice:Invoice):ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.save(invoice), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody invoice:Invoice):ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.update(invoice), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody invoice:Invoice):ResponseEntity<Invoice>{
        return ResponseEntity(invoiceService.updateTotal(invoice), HttpStatus.OK)
    }

}