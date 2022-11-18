package com.restapi.mongo.restapi.mapper

import com.restapi.mongo.restapi.http.PersonDTO
import com.restapi.mongo.restapi.model.Item
import org.springframework.stereotype.Component

@Component
class PersonConverter () {

    fun toEntity(person: PersonDTO) =
        Item(nome = person.nome, status = person.status)

    fun toDTO(person: Item) =
        PersonDTO(nome = person.nome, status = person.status)

    fun toDTO(itens: List<Item>) =
        itens.map{itn -> PersonDTO(nome = itn.nome, status = itn.status)}

}