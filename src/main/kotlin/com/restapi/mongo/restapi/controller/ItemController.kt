package com.restapi.mongo.restapi.controller

import com.restapi.mongo.restapi.http.ItemFilter
import com.restapi.mongo.restapi.model.Item
import com.restapi.mongo.restapi.repository.ItemRepository
import com.restapi.mongo.restapi.repository.impl.ItemFilterRepository
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/itens")
class ItemController(private val itemRepository: ItemRepository,
                     private val itemFilterRepository: ItemFilterRepository) {

    @GetMapping
    fun getAll(): ResponseEntity<List<Item>> {
        val itens = itemRepository.findAll()
        return ResponseEntity.ok(itens)
    }

    @GetMapping("/{id}")
    fun getOne(@PathVariable("id") id: String): ResponseEntity<Item> {
        val patient = itemRepository.findOneById(ObjectId(id))
        return ResponseEntity.ok(patient)
    }

    @GetMapping("/filter")
    fun getFilter(filter: ItemFilter): ResponseEntity<List<Item>> {
        val itens = itemFilterRepository.findByFilter(filter)
        return ResponseEntity.ok(itens)
    }
}