package com.restapi.mongo.restapi.repository

import com.restapi.mongo.restapi.http.ItemFilter
import com.restapi.mongo.restapi.model.Item

interface IItemFilter {

    fun findByFilter(filter: ItemFilter): List<Item>

}