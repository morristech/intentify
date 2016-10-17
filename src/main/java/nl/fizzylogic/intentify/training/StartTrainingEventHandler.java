package nl.fizzylogic.intentify.training;

import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import nl.fizzylogic.intentify.common.EventBusAddresses;

/**
 * Event handler responsible for starting training cycles
 */
public class StartTrainingEventHandler {
    private static Logger logger = LoggerFactory.getLogger(StartTrainingEventHandler.class);

    /**
     * Initializes a new instance of {@link SampleSubmissionEventHandler}
     */
    private StartTrainingEventHandler() {

    }

    /**
     * Binds the event handler to the event bus
     *
     * @param eventBus Event bus to bind to
     */
    public static void bind(EventBus eventBus) {
        StartTrainingEventHandler eventHandler = new StartTrainingEventHandler();
        eventBus.consumer(EventBusAddresses.START_TRAINING, eventHandler::handle);
    }

    /**
     * Handles the submission of a new training sample
     *
     * @param message Message containing new training data
     */
    @SuppressWarnings("squid:UnusedPrivateMethod")
    private void handle(Message<String> message) {
        logger.info("Starting new training cycle");
    }
}
