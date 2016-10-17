package nl.fizzylogic.intentify.training;

import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import nl.fizzylogic.intentify.common.EventBusAddresses;
import nl.fizzylogic.intentify.entities.SubmitSampleForm;
import nl.fizzylogic.intentify.entities.TrainingSample;

/**
 * Handles incoming training data
 */
public class SampleSubmissionEventHandler {
    private static final Logger logger = LoggerFactory.getLogger(SampleSubmissionEventHandler.class);

    private TrainingSampleService trainingSampleService;

    /**
     * Initializes a new instance of {@link SampleSubmissionEventHandler}
     *
     * @param trainingSampleService
     */
    private SampleSubmissionEventHandler(TrainingSampleService trainingSampleService) {

        this.trainingSampleService = trainingSampleService;
    }

    /**
     * Binds the event handler to the event bus
     *
     * @param eventBus Event bus to bind to
     */
    public static void bind(EventBus eventBus, TrainingSampleService trainingSampleService) {
        SampleSubmissionEventHandler eventHandler = new SampleSubmissionEventHandler(trainingSampleService);
        eventBus.consumer(EventBusAddresses.SAMPLE_SUBMISSION, eventHandler::handle);
    }

    /**
     * Handles the submission of a new training sample
     *
     * @param message Message containing new training data
     */
    @SuppressWarnings("squid:UnusedPrivateMethod")
    private void handle(Message<SubmitSampleForm> message) {
        logger.info("Received training sample {0}", message.body());
        trainingSampleService.storeSample(new TrainingSample(message.body().getIntent(), message.body().getText()));
    }
}
