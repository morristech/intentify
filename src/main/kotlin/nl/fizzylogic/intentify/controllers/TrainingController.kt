package nl.fizzylogic.intentify.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Endpoint for training the service
 */
@RestController
class TrainingController {
    /**
     * Starts a new training run
     */
    @RequestMapping(
            path = arrayOf("/api/training/start"),
            method = arrayOf(RequestMethod.POST),
            consumes = arrayOf("application/json"),
            produces = arrayOf("application/json")
    )
    fun startTraining(): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build()
    }

    /**
     * Trains a single sample
     */
    @RequestMapping(
            path = arrayOf("/api/training/status"),
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf("application/json")
    )
    fun getTrainingStatus(): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build()
    }
}