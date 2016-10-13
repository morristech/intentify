package nl.fizzylogic.intentify.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import nl.fizzylogic.intentify.entities.SubmitSampleForm
import nl.fizzylogic.intentify.entities.TrainingSample
import nl.fizzylogic.intentify.repositories.TrainingSampleRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.any
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
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

    @MockBean
    lateinit var trainingSampleRepository: TrainingSampleRepository

    @Test
    fun submitSampleReturnsOk() {
        `when`(trainingSampleRepository.save(any(TrainingSample::class.java)))
            .thenReturn(TrainingSample("dummy", "dummy"))

        mockMvc.perform(submitSampleRequest("This is a sample sentence", "sample"))
            .andExpect(MockMvcResultMatchers.status().isAccepted)

        verify(trainingSampleRepository).save(any(TrainingSample::class.java))
    }

    fun submitSampleWithInvalidDataReturnsBadRequest() {
        mockMvc.perform(submitSampleRequest(null, null))
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
    }

    private fun submitSampleRequest(text: String?, intent: String?): MockHttpServletRequestBuilder {
        val mapper = ObjectMapper().registerModule(KotlinModule())

        return MockMvcRequestBuilders.post("/api/training/samples")
            .accept("application/json")
            .contentType("application/json")
            .content(mapper.writeValueAsString(SubmitSampleForm(text, intent)))
    }
}