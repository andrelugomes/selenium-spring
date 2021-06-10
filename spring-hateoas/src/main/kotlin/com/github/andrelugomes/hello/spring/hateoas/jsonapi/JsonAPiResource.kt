package com.github.andrelugomes.hello.spring.hateoas.jsonapi

import com.toedter.spring.hateoas.jsonapi.MediaTypes.JSON_API_VALUE
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.Link
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/json-api")
class JsonAPiResource {

    @GetMapping("/{id}", produces = [JSON_API_VALUE])
    fun getSample(
        @PathVariable id: Long
    ): EntityModel<Sample> {
        val sample = Sample(id, "Sample name : $id")
        val link: Link = linkTo(JsonAPiResource::class.java).slash(sample.id).withSelfRel()

        return EntityModel.of(sample).add(link)
    }
}