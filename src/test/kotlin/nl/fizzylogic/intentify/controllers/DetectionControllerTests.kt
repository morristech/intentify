package nl.fizzylogic.intentify.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import nl.fizzylogic.intentify.entities.DetectionForm
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@WebMvcTest(DetectionController::class)
class DetectionControllerTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun detectIntentReturnsNotImplemented() {
        mockMvc.perform(detectionRequest("This is a sample sentence")).andExpect(status().isNotImplemented)
    }

    private fun detectionRequest(text: String): MockHttpServletRequestBuilder {
        val mapper = ObjectMapper().registerModule(KotlinModule())

        return post("/api/detect")
                .accept("application/json")
                .contentType("application/json")
                .content(mapper.writeValueAsString(DetectionForm(text)))
    }
}