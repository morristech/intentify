package nl.fizzylogic.intentify.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import nl.fizzylogic.intentify.forms.SubmitSampleForm
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@RunWith(SpringRunner::class)
@WebMvcTest(TrainingController::class)
class TrainingControllerTests {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun startTrainingReturnsNotImplemented() {
        mockMvc.perform(startTrainingRequest())
                .andExpect(status().isNotImplemented)
    }

    @Test
    fun getStatusReturnsNotImplemented() {
        mockMvc.perform(get("/api/training/status").accept("application/json"))
                .andExpect(status().isNotImplemented)
    }

    private fun startTrainingRequest(): MockHttpServletRequestBuilder {
        return post("/api/training/start")
                .accept("application/json")
                .contentType("application/json")
    }
}