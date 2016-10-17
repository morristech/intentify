package nl.fizzylogic.intentify.training;

import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import nl.fizzylogic.intentify.common.EventBusAddresses;

/**
 * Handles resets of the sample set
 */
public class ResetSampleSetEventHandler {
    private TrainingSampleService trainingSampleService;

    /**
     * Initializes a new instance of {@link SampleSubmissionEventHandler}
     *
     * @param trainingSampleService
     */
    private ResetSampleSetEventHandler(TrainingSampleService trainingSampleService) {

        this.trainingSampleService = trainingSampleService;
    }

    /**
     * Binds the event handler to the event bus
     *
     * @param eventBus Event bus to bind to
     */
    public static void bind(EventBus eventBus, TrainingSampleService trainingSampleService) {
        ResetSampleSetEventHandler eventHandler = new ResetSampleSetEventHandler(trainingSampleService);
        eventBus.consumer(EventBusAddresses.RESET_SAMPLES, eventHandler::handle);
    }

    /**
     * Handles the submission of a new training sample
     *
     * @param message Message containing new training data
     */
    @SuppressWarnings("squid:UnusedPrivateMethod")
    private void handle(Message<String> message) {
        trainingSampleService.reset();
    }
}
