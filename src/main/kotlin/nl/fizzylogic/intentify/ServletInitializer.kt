package nl.fizzylogic.intentify
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer

/**
 * Initializes the servlet configuration in case the application is run on top of a Java application server
 */
class ServletInitializer : SpringBootServletInitializer() {
    /**
     * Configures the servlet
     */
    override fun configure(application: SpringApplicationBuilder) : SpringApplicationBuilder {
        return application.sources(IntentifyApplication::class.java)
    }

}