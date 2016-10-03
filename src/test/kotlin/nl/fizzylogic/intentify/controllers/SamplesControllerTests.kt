package nl.fizzylogic.intentify.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import nl.fizzylogic.intentify.forms.DetectionForm
import nl.fizzylogic.intentify.forms.SubmitSampleForm
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@WebMvcTest(SamplesController::class)
class SamplesControllerTests {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun submitSampleReturnsNotImplemented() {
        mockMvc.perform(submitSampleRequest("This is a sample sentence", "sample")).andExpect(MockMvcResultMatchers.status().isNotImplemented)
    }

    private fun submitSampleRequest(text: String, intent: String): MockHttpServletRequestBuilder {
        val mapper = ObjectMapper().registerModule(KotlinModule())

        return MockMvcRequestBuilders.post("/api/training/samples")
                .accept("application/json")
                .contentType("application/json")
                .content(mapper.writeValueAsString(SubmitSampleForm(text, intent)))
    }
}