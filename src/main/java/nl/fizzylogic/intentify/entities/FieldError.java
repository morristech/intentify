package nl.fizzylogic.intentify.entities;

/**
 * Represents a single error for a field
 */
public class FieldError {
    private final String field;
    private final String message;

    /**
     * Initializes a new instance of {@link FieldError}
     *
     * @param field
     * @param message
     */
    public FieldError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    /**
     * Gets the field the error occurred on
     *
     * @return The name of the field
     */
    public String getField() {
        return field;
    }

    /**
     * Gets the message for the field
     *
     * @return The message for the field
     */
    public String getMessage() {
        return message;
    }
}
