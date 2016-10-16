package nl.fizzylogic.intentify.restservice;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import nl.fizzylogic.intentify.common.MessageCodecs;

/**
 * Main verticle for the REST interface
 */
public class RestServiceVerticle extends AbstractVerticle {
    private static final Logger logger = LoggerFactory.getLogger(RestServiceVerticle.class);

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        Router router = Router.router(vertx);
        HttpServer server = vertx.createHttpServer();

        router.route().handler(BodyHandler.create());
        SubmitSampleRoute.bind(router, vertx.eventBus());

        server.requestHandler(router::accept);

        server.listen(8080, result -> {
           if(result.succeeded()) {
               logger.info("Webserver started on port 8080");
               startFuture.complete();
           } else {
               startFuture.fail(result.cause());
           }
        });
    }
}
