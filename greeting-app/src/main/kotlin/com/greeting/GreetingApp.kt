package com.greeting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GreetingApp

fun main(args: Array<String>) {
    runApplication<GreetingApp>(*args)
}
