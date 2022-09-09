package com.forst.tools

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import kotlin.reflect.full.companionObject

class Loggers<in R : Any> : ReadOnlyProperty<R, Logger> {

    private var logger: Logger? = null

    override fun getValue(thisRef: R, property: KProperty<*>): Logger {
        return logger ?: getLogger(thisRef.javaClass).also {
            logger = it
        }
    }
}

fun <T : Any> getLogger(forClass: Class<T>): Logger = LoggerFactory.getLogger(
    getClassForLogging(forClass)
)

private fun <T : Any> getClassForLogging(javaClass: Class<T>): Class<*> {
    return javaClass.enclosingClass?.takeIf {
        it.kotlin.companionObject?.java == javaClass
    } ?: javaClass
}