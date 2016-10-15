package nl.fizzylogic.intentify.extensions

import io.vertx.core.http.HttpServerResponse

/**
 * Sets the status code for the current request
 * @param statusCode The statuscode for the response
 * @param build The builder to configure the rest of the response
 */
fun HttpServerResponse.status(statusCode: Int, builder: HttpServerResponse.() -> Unit) =
        builder(this.setStatusCode(statusCode))
