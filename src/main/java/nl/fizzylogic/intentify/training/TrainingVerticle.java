package nl.fizzylogic.intentify.training;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.MessageCodec;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import nl.fizzylogic.intentify.common.MessageCodecs;

/**
 * Hosts the training process in the service
 */
public class TrainingVerticle extends AbstractVerticle {
    private static final Logger logger = LoggerFactory.getLogger(TrainingVerticle.class);

    @Override
    public void start() throws Exception {
        MessageCodecs.register(vertx.eventBus());
        SampleSubmissionEventHandler.bind(vertx.eventBus());

        logger.info("Training verticle intialized");
    }
}
