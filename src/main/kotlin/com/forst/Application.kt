package com.forst

import com.forst.plugins.configureRouting
import com.forst.plugins.configureSerialization
import com.forst.plugins.configureSockets
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSerialization()
        configureSockets()
        configureRouting()
    }.start(wait = true)
}