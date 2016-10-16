package nl.fizzylogic.intentify.entities;

import java.util.List;

/**
 * Represents a set of validation constraint violations
 */
public class ValidationError {
    private List<FieldError> errors;

    public ValidationError(List<FieldError> errors) {
        this.errors = errors;
    }

    public List<FieldError> getErrors() {
        return errors;
    }
}
