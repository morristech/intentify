package nl.fizzylogic.intentify;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import nl.fizzylogic.intentify.common.Configuration;
import nl.fizzylogic.intentify.restservice.RestServiceVerticle;
import nl.fizzylogic.intentify.training.TrainingSampleService;
import nl.fizzylogic.intentify.training.TrainingSampleServiceImpl;
import nl.fizzylogic.intentify.training.TrainingVerticle;

/**
 * Startup verticle
 */
public class IntentifyVerticle extends AbstractVerticle {
    /**
     * Starts the application
     *
     * @param startFuture Future to complete when the startup procedure is finished
     * @throws Exception Gets thrown when startup fails
     */
    @Override
    public void start(Future<Void> startFuture) throws Exception {
        TrainingSampleService trainingSampleService = new TrainingSampleServiceImpl(new Configuration());

        vertx.deployVerticle(new RestServiceVerticle());
        vertx.deployVerticle(new TrainingVerticle(trainingSampleService));

        startFuture.complete();
    }
}
