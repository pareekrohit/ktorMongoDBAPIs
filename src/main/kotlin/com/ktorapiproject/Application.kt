package com.ktorapiproject

import com.ktorapiproject.plugins.*
import com.ktorapiproject.repository.DatabaseFactory
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
            .start(wait = true)
}

fun Application.module() {
    val db =DatabaseFactory()
    configureSerialization()
    configureMonitoring()
    configureRouting(db)
}
