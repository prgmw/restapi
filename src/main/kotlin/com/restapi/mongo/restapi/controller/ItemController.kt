package com.restapi.mongo.restapi.controller

import com.restapi.mongo.restapi.http.ItemFilter
import com.restapi.mongo.restapi.http.PersonDTO
import com.restapi.mongo.restapi.mapper.PersonConverter
import com.restapi.mongo.restapi.model.Item
import com.restapi.mongo.restapi.repository.ItemRepository
import com.restapi.mongo.restapi.repository.impl.ItemFilterRepository
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/itens")
class ItemController(
    private val itemRepository: ItemRepository,
    private val itemFilterRepository: ItemFilterRepository,
    private val personConverter: PersonConverter
) {
    @PostMapping
    fun createItem(@RequestBody itemDTO: PersonDTO): ResponseEntity<PersonDTO> {
        val item = itemRepository.save(personConverter.toEntity(itemDTO))
        return ResponseEntity.ok(personConverter.toDTO(item))
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<PersonDTO>> {
        val itens = itemRepository.findAll()
        return ResponseEntity.ok(personConverter.toDTO(itens))
    }

    @GetMapping("/{id}")
    fun getOne(@PathVariable("id") id: String): ResponseEntity<PersonDTO> {
        val item = itemRepository.findOneById(ObjectId(id))
        return ResponseEntity.ok(personConverter.toDTO(item))
    }

    @GetMapping("/filter")
    fun getFilter(filter: ItemFilter): ResponseEntity<List<PersonDTO>> {
        val itens = itemFilterRepository.findByFilter(filter)
        return ResponseEntity.ok(personConverter.toDTO(itens))
    }
}