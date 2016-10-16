package nl.fizzylogic.intentify.training;

import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import nl.fizzylogic.intentify.common.EventBusAddresses;
import nl.fizzylogic.intentify.entities.SubmitSampleForm;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

/**
 * Handles incoming training data
 */
public class SampleSubmissionEventHandler {
    private static final Logger logger = LoggerFactory.getLogger(SampleSubmissionEventHandler.class);

    /**
     * Initializes a new instance of {@link SampleSubmissionEventHandler}
     */
    private SampleSubmissionEventHandler() {

    }

    /**
     * Binds the event handler to the event bus
     * @param eventBus Event bus to bind to
     */
    public static void bind(EventBus eventBus) {
        eventBus.consumer(EventBusAddresses.SAMPLE_SUBMISSION, SampleSubmissionEventHandler::handle);
    }

    /**
     * Handles the submission of a new training sample
     * @param message Message containing new training data
     */
    private static void handle(Message<SubmitSampleForm> message) {
        logger.info("Received training sample {0}", message.body());
    }
}
