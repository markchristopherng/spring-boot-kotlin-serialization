package com.greeting.model

import kotlinx.serialization.Serializable

@Serializable
data class GreetingRequest(val firstName: String, val lastName: String)
