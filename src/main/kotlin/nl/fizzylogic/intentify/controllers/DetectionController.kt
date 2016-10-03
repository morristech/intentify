package nl.fizzylogic.intentify.controllers

import nl.fizzylogic.intentify.forms.DetectionForm
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class DetectionController {
    /**
     * Detects the intent of a sentence and the entities in the sentence
     */
    @RequestMapping(
            path = arrayOf("/api/detect"),
            method = arrayOf(RequestMethod.POST),
            consumes = arrayOf("application/json"),
            produces = arrayOf("application/json")
    )
    fun detectIntent(@RequestBody @Valid form: DetectionForm, bindingResult: BindingResult): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build()
    }
}