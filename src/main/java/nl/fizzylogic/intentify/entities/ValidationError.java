package nl.fizzylogic.intentify.entities;

import java.util.List;

/**
 * Represents a set of validation constraint violations
 */
public class ValidationError {
    private final List<FieldError> errors;

    /**
     * Initializes a new instance of {@link ValidationError}
     * @param errors
     */
    public ValidationError(List<FieldError> errors) {
        this.errors = errors;
    }

    /**
     * Gets the errors found in the input
     * @return  The list of errors for each field
     */
    public List<FieldError> getErrors() {
        return errors;
    }
}
