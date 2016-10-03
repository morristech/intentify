package nl.fizzylogic.intentify

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Main application class
 */
@SpringBootApplication
open class IntentifyApplication {

}

/**
 * Starts the application
 */
fun main(args: Array<String>) {
    SpringApplication.run(IntentifyApplication())
}