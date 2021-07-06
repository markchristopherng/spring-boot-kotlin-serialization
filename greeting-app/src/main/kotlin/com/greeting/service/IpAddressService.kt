package com.greeting.service

import com.greeting.json.JsonParser
import org.springframework.http.HttpMethod
import org.springframework.http.RequestEntity
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.KotlinSerializationJsonHttpMessageConverter
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URI

interface IpAddressService {
    fun getIpAddress(): IpAddress
}

@Service
class IpAddressServiceImpl : IpAddressService {

    val restTemplate = RestTemplate()

    init {
        restTemplate.messageConverters = mutableListOf<HttpMessageConverter<*>>(
            KotlinSerializationJsonHttpMessageConverter(JsonParser().json)
        )
    }

    override fun getIpAddress(): IpAddress {
        var ipAddress = IpAddress("")
        try {
            val requestEntity = RequestEntity<IpAddress>(HttpMethod.GET, URI("https://api.ipify.org?format=json"))
            ipAddress = restTemplate.exchange(requestEntity, IpAddress::class.java).body
        } catch (e: Exception) {
            ipAddress.ip = "unavailable"
        }
        return ipAddress
    }
}
