package nl.fizzylogic.intentify.extensions

import io.vertx.core.Vertx

/**
 * Creates a new vertx instance
 * @param builder The builder function to configure the vertx instance
 */
fun vertx(builder: Vertx.() -> Unit) = builder(Vertx.vertx())