package com.greeting.json

import kotlinx.serialization.json.Json

class JsonParser {
    val json = Json { ignoreUnknownKeys = true; isLenient = true; }
}
