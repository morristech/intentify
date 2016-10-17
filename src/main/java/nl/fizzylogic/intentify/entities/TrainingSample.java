package nl.fizzylogic.intentify.entities;

/**
 * Represents a single training sample
 */
public final class TrainingSample {
    private final String text;
    private final String intent;

    public TrainingSample(String intent, String text) {
        this.text = text;
        this.intent = intent;
    }

    public String getText() {
        return text;
    }

    public String getIntent() {
        return intent;
    }
}
