package nl.fizzylogic.intentify.entities

/**
 * Displays an error for a single field
 * @param field The name of the field the error occured for
 * @param message The error message for the field
 */
data class FieldErrorMessage(val field: String, val message: String) {
}