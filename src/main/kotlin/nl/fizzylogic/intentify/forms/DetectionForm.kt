package nl.fizzylogic.intentify.forms

import javax.validation.constraints.NotNull

/**
 * Contains the data for the sentence detection
 */
data class DetectionForm(@NotNull var text: String) {
}