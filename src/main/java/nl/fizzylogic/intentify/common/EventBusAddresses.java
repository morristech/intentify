package nl.fizzylogic.intentify.common;

/**
 * Defines the available locations where to publish and consume events
 */
public class EventBusAddresses {
    /**
     * Initializes a new instance of {@link EventBusAddresses}
     */
    private EventBusAddresses() {
        // Does nothing, this class should not be instantiated
    }

    /**
     * Send/Receive training samples
     */
    public static final String SAMPLE_SUBMISSION = "samples.submit";
}
