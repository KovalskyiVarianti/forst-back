package com.forst.plugins

import com.forst.tools.getLogger
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    val logger = getLogger(javaClass)

    routing {
        get("/") {
            val text = "Hello Forst!"
            call.respondText(text)
            logger.debug("GET: $text")
        }
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}