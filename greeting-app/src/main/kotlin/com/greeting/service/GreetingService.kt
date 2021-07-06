package com.greeting.service

import com.greeting.model.GreetingRequest
import com.greeting.model.GreetingResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface GreetingService {
    fun greeting(request: GreetingRequest): GreetingResponse
}

@Service
class GreetingServiceImpl : GreetingService {

    @Autowired
    lateinit var ipAddressService: IpAddressService

    override fun greeting(request: GreetingRequest): GreetingResponse {
        val ipAddress = ipAddressService.getIpAddress()
        return GreetingResponse("Hello ${request.firstName} ${request.lastName}", ipAddress.ip)
    }
}
