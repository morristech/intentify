package nl.fizzylogic.intentify.extensions

import io.vertx.core.Vertx
import io.vertx.core.http.HttpServer
import org.slf4j.LoggerFactory

/**
 * Creates a new HTTP server based on the vertx instance
 * @param hostName The hostname of the server to listen on
 * @param port The port of the server to listen on
 * @param builder The builder to configure the HTTP server
 */
fun Vertx.httpServer(hostName: String, port: Int, builder: HttpServer.() -> Unit) {
    val logger = LoggerFactory.getLogger("Vertx.HttpServer")

    val serverInstance = createHttpServer()
    builder(serverInstance)

    logger.info("Starting server on $hostName:$port", hostName, port)

    serverInstance.listen(port, hostName)
}
