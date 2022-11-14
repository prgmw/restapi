package com.restapi.mongo.restapi.repository.impl

import com.restapi.mongo.restapi.http.ItemFilter
import com.restapi.mongo.restapi.model.Item
import com.restapi.mongo.restapi.repository.IItemFilter
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class ItemFilterRepository(val mongoTemplate: MongoTemplate) : IItemFilter {

    override fun findByFilter(filter: ItemFilter): List<Item> {
        val query = Query()

        if (!filter?.nome.isNullOrBlank()) {
            query.addCriteria(Criteria.where("nome").isEqualTo(filter.nome))
        }

        if (!filter?.status.isNullOrBlank()) {
            query.addCriteria(Criteria.where("status").isEqualTo(filter.status))
        }

        return mongoTemplate.find<Item>(query)

    }
}