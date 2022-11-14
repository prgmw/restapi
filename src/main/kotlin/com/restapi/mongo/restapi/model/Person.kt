package com.restapi.mongo.restapi.model

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Item (
    val id: ObjectId = ObjectId.get(),
    val nome: String,
    val status: String
)