package nl.fizzylogic.intentify;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Startup verticle
 */
public class IntentifyVerticle extends AbstractVerticle {
    /**
     * Starts the application
     * @param startFuture   Future to complete when the startup procedure is finished
     * @throws Exception    Gets thrown when startup fails
     */
    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.deployVerticle("nl.fizzylogic.intentify.restservice.RestServiceVerticle");
        vertx.deployVerticle("nl.fizzylogic.intentify.training.TrainingVerticle");

        startFuture.complete();
    }
}
