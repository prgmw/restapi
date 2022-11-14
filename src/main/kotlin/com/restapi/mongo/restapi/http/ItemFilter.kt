package com.restapi.mongo.restapi.http

import org.bson.types.ObjectId

class ItemFilter (
    val id: ObjectId?,
    val nome : String?,
    val status : String?
)