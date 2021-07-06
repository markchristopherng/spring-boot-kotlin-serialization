package com.greeting.controller

import com.greeting.model.GreetingRequest
import com.greeting.model.GreetingResponse
import com.greeting.service.GreetingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
class GreetingController {

    @Autowired
    lateinit var greetingServie: GreetingService

    @RequestMapping("/greeting", method = [RequestMethod.POST])
    fun greeting(@RequestBody request: GreetingRequest): GreetingResponse {
        return greetingServie.greeting(request)
    }
}
