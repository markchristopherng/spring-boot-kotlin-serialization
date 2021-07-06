package com.greeting.json

import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.KotlinSerializationJsonHttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
open class ConfigureMessageConverters() : WebMvcConfigurer {

    override fun extendMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        val converter = KotlinSerializationJsonHttpMessageConverter(JsonParser().json)
        converters.forEachIndexed { index, httpMessageConverter ->
            if (httpMessageConverter is KotlinSerializationJsonHttpMessageConverter) {
                converters[index] = converter
                return
            }
        }
    }
}
