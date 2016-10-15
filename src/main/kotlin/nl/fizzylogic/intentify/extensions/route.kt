package nl.fizzylogic.intentify.extensions

import io.vertx.core.http.HttpServerRequest
import io.vertx.core.http.HttpServerResponse
import io.vertx.ext.web.Route
import io.vertx.ext.web.RoutingContext
import org.slf4j.LoggerFactory

/**
 * Binds a handler to a route
 * @param builder The builder to configure the route
 */
fun Route.routeHandler(builder: HttpServerResponse.(request: HttpServerRequest, routeContext: RoutingContext) -> Unit) {
    this.handler { context ->
        builder(context.response(), context.request(), context)
    }
}

/**
 * Binds a handler to a route
 * @param builder The builder to configure the route
 */
fun Route.routeHandler(builder: HttpServerResponse.(request: HttpServerRequest) -> Unit) {
    val logger = LoggerFactory.getLogger("Vertx.Route")

    logger.info("Binding routeHandler to {}", this.path)

    this.handler { context ->
        builder(context.response(), context.request())
    }
}