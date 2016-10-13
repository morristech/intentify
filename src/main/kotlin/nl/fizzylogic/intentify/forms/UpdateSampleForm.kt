package nl.fizzylogic.intentify.forms

import javax.validation.constraints.NotNull

data class UpdateSampleForm(
    @NotNull
    var text: String,

    @NotNull
    var intent: String
)