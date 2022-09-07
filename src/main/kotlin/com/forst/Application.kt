package com.forst

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.forst.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSerialization()
        configureSockets()
        configureRouting()
    }.start(wait = true)
}
