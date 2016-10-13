package nl.fizzylogic.intentify.entities

import org.springframework.validation.FieldError

/**
 * Represents a validation error
 */
class ValidationError {
    /**
     * Initializes a new instance of ValidationError
     * @param allErrors The errors that were detected by the controller
     */
    constructor(allErrors: List<FieldError>) {
        errors = allErrors.map { element ->
            FieldErrorMessage(element.field, element.defaultMessage)
        }.toList()
    }

    /**
     * Gets the errors that occurred
     */
    val errors: List<FieldErrorMessage>
}