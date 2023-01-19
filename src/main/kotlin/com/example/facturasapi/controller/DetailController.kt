package com.example.facturasapi.controller

import com.example.facturasapi.model.Client
import com.example.facturasapi.model.Detail
import com.example.facturasapi.service.DetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/detail")
class DetailController {
    @Autowired
    lateinit var detailService: DetailService
    @PostMapping
    fun save (@RequestBody detail:Detail): Detail {
        return detailService.save(detail)
    }
    @GetMapping
    fun list ():List<Detail>{
        return detailService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable ("id") id: Long):ResponseEntity<Detail>{
        return ResponseEntity(detailService.listById(id), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody detail: Detail):ResponseEntity<Detail>{
        return ResponseEntity(detailService.update(detail), HttpStatus.OK)
    }

    @PatchMapping
    fun updateQuantity (@RequestBody detail: Detail): ResponseEntity<Detail> {
        return ResponseEntity(detailService.updateQuantity(detail), HttpStatus.OK)
    }
}