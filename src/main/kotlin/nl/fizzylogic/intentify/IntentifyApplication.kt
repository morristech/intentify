package nl.fizzylogic.intentify

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Main application class
 */
@SpringBootApplication
@EnableSwagger2()
@EnableWebMvc()
open class IntentifyApplication {

}

/**
 * Starts the application
 */
fun main(args: Array<String>) {
    SpringApplication.run(IntentifyApplication::class.java, *args)
}