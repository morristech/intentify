package nl.fizzylogic.intentify.common;

/**
 * Defines the available locations where to publish and consume events
 */
public class EventBusAddresses {
    /**
     * Send/Receive training samples
     */
    public static final String SAMPLE_SUBMISSION = "samples.submit";

    /**
     * Reset sample set
     */
    public static final String RESET_SAMPLES = "samples.reset";

    /**
     * Initializes a new instance of {@link EventBusAddresses}
     */
    private EventBusAddresses() {
        // Does nothing, this class should not be instantiated
    }
}
