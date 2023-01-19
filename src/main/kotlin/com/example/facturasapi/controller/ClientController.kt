package com.example.facturasapi.controller

import com.example.facturasapi.model.Client
import com.example.facturasapi.service.ClientService
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/client")
class ClientController {

    @Autowired
    lateinit var  clientService: ClientService

    @GetMapping
    fun list():List<Client>{
        return clientService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable ("id") id: Long):ResponseEntity<Client>{
        return ResponseEntity(clientService.listById(id), HttpStatus.OK)
    }
    @PostMapping
    fun save(@RequestBody @Valid client:Client):ResponseEntity<Client>{
        return ResponseEntity(clientService.save(client), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody client:Client):ResponseEntity<Client>{
        return ResponseEntity(clientService.update(client), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody client:Client):ResponseEntity<Client>{
        return ResponseEntity(clientService.updateName(client), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return clientService.delete(id)
    }

}