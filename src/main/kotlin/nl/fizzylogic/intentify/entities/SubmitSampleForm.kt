package nl.fizzylogic.intentify.entities

import javax.validation.constraints.NotNull

/**
 * Contains the data for training a single sample
 */
data class SubmitSampleForm(
        /**
         * The text of the sentence to train
         */
        @NotNull
        var text: String?,

        /**
         * Intent of the sentence
         */
        @NotNull
        var intent: String?
)