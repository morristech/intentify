package nl.fizzylogic.intentify.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import nl.fizzylogic.intentify.forms.DetectionForm
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.mock.web.MockHttpServletRequest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

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