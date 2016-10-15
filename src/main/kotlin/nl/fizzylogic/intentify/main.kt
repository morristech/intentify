package nl.fizzylogic.intentify

import nl.fizzylogic.intentify.extensions.* // ktlint-disable no-wildcard-imports

fun main(args: Array<String>) {
    vertx {
        // Create an application router to handle incoming HTTP requests.
        // Bind routes to it and provide a handler for each route.
        val appRouter = router {
            get("/api/version") {
                routeHandler { request ->
                    status(200) {
                        end("1.0.0")
                    }
                }
            }
        }

        // Create a new instance of the HTTP server and bind it to port 8080.
        // Configure the server so that it has a single request handler that binds to the router.
        httpServer("0.0.0.0", 8080) {
            requestHandler { request ->
                appRouter.accept(request)
            }
        }
    }
}
