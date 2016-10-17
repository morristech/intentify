package nl.fizzylogic.intentify.training;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import nl.fizzylogic.intentify.common.MessageCodecs;

/**
 * Hosts the training process in the service
 */
public class TrainingVerticle extends AbstractVerticle {
    private static final Logger logger = LoggerFactory.getLogger(TrainingVerticle.class);

    private final TrainingSampleService trainingSampleService;

    /**
     * Initializes a new instance of {@link TrainingVerticle}
     *
     * @param trainingSampleService Training sample service for storing samples
     */
    public TrainingVerticle(TrainingSampleService trainingSampleService) {
        this.trainingSampleService = trainingSampleService;
    }

    /**
     * Starts the verticle
     *
     * @throws Exception Gets thrown when startup fails
     */
    @Override
    public void start() throws Exception {
        MessageCodecs.register(vertx.eventBus());

        SampleSubmissionEventHandler.bind(vertx.eventBus(), trainingSampleService);
        ResetSampleSetEventHandler.bind(vertx.eventBus(), trainingSampleService);
        StartTrainingEventHandler.bind(vertx.eventBus());

        logger.info("Training verticle intialized");
    }
}
