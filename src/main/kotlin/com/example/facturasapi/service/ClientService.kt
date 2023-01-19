package com.example.facturasapi.service

import com.example.facturasapi.model.Client
import com.example.facturasapi.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ClientService {

    @Autowired
    lateinit var clientRepository: ClientRepository

    fun list():List<Client>{
        return clientRepository.findAll()
    }

    fun listById (id: Long?): Client{
        return clientRepository.findByid(id)
    }


    fun save(client: Client):Client{
       try{
           client.fullname?.takeIf { it.trim().isNotEmpty() }
               ?: throw Exception("fullname no debe ser vacio")
           client.nui?.takeIf { it.trim().isNotEmpty() }
               ?: throw Exception("nui no debe ser vacio")

           return clientRepository.save(client)
       } catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }


    }


    fun update(client:Client): Client {
        try{
            clientRepository.findByid(client.id)
                ?: throw Exception("ID no existe")

            return clientRepository.save(client)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


    fun updateName(client:Client): Client {
        try{
            val response = clientRepository.findByid(client.id)
                ?: throw Exception("ID no existe")
            response.apply {
                fullname =client.fullname
            }
            return clientRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun delete (id: Long):Boolean?{
        clientRepository.findById(id) ?:
        throw  Exception()
        clientRepository.deleteById(id!!)
        return true
    }

}




