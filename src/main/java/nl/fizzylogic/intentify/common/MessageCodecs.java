package nl.fizzylogic.intentify.common;

import io.vertx.core.eventbus.EventBus;

/**
 * Registers the message codes for the event bus
 */
public class MessageCodecs {
    /**
     * Initializes a new instance of {@link MessageCodecs}
     */
    private MessageCodecs() {

    }

    /**
     * Binds the message codecs to the event bus
     * @param eventBus Event bus to bind to
     */
    public static void register(EventBus eventBus) {
        eventBus.registerCodec(new SubmitSampleFormCodec());
    }
}
