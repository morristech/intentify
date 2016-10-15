package nl.fizzylogic.intentify.extensions

import io.vertx.core.Vertx
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router

/**
 * Creates a new router instance and configures it
 * @param routerBuilder The function to configure the router
 */
fun Vertx.router(routerBuilder: Router.() -> Unit): Router {
    val routerInstance = Router.router(this)
    routerBuilder(routerInstance)

    return routerInstance
}

/**
 * Configures a route using the GET method
 * @param path The path to match for the route
 * @param routeBuilder The builder to configure the route
 */
fun Router.get(path: String, routeBuilder: Route.() -> Unit) {
    val route = this.get(path)
    routeBuilder(route)
}

/**
 * Configures a route using the POST method
 * @param path The path to match for the route
 * @param routeBuilder The builder to configure the route
 */
fun Router.post(path: String, routeBuilder: Route.() -> Unit) {
    val route = this.post(path)
    routeBuilder(route)
}

/**
 * Configures a route using the PUT method
 * @param path The path to match for the route
 * @param routeBuilder The builder to configure the route
 */
fun Router.put(path: String, routeBuilder: Route.() -> Unit) {
    val route = this.put(path)
    routeBuilder(route)
}

/**
 * Configures a route using the DELETE method
 * @param path The path to match for the route
 * @param routeBuilder The builder to configure the route
 */
fun Router.delete(path: String, routeBuilder: Route.() -> Unit) {
    val route = this.delete(path)
    routeBuilder(route)
}

/**
 * Configures a route using the PATCH method
 * @param path The path to match for the route
 * @param routeBuilder The builder to configure the route
 */
fun Router.patch(path: String, routeBuilder: Route.() -> Unit) {
    val route = this.patch(path)
    routeBuilder(route)
}

