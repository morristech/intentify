package nl.fizzylogic.intentify.entities

import javax.validation.constraints.NotNull

data class UpdateSampleForm(
    @NotNull
    var text: String,

    @NotNull
    var intent: String
)