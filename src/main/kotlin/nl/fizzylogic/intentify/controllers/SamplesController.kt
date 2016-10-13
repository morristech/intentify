package nl.fizzylogic.intentify.controllers

import nl.fizzylogic.intentify.forms.SubmitSampleForm
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * Endpoint for submitting samples
 */
@RestController
class SamplesController {
    /**
     * Submits a new sample to the service for training
     */
    @RequestMapping(
            path = arrayOf("/api/training/samples"),
            method = arrayOf(RequestMethod.POST),
            consumes = arrayOf("application/json"),
            produces = arrayOf("application/json")
    )
    fun submitSample(@RequestBody @Valid form: SubmitSampleForm, bindingResult: BindingResult): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build()
    }
}