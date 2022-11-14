package com.restapi.mongo.restapi.repository

import com.restapi.mongo.restapi.model.Item
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface ItemRepository : MongoRepository<Item, String> {

    fun findOneById(id: ObjectId): Item

    override fun deleteAll()
}