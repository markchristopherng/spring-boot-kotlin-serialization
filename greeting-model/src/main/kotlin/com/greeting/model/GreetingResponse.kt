package com.greeting.model

import kotlinx.serialization.Serializable

@Serializable
data class GreetingResponse(val message: String, val ipAddress: String)
