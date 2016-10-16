package nl.fizzylogic.intentify.restservice;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.json.Json;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import nl.fizzylogic.intentify.common.MessageCodecs;
import nl.fizzylogic.intentify.entities.SubmitSampleForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class RestServiceVerticleTest {
    private Vertx vertx;

    @Before
    public void setUp(TestContext testContext) {
        vertx = Vertx.vertx();

        vertx.deployVerticle(RestServiceVerticle.class.getName(), testContext.asyncAssertSuccess());

        MessageCodecs.register(vertx.eventBus());
    }

    @After
    public void tearDown(TestContext testContext) {
        vertx.close(testContext.asyncAssertSuccess());
    }

    @Test
    public void submitSampleWithValidDataReturns202(TestContext testContext) {
        submitTrainingSample(testContext, new SubmitSampleForm("Test sentence", "test"), 202);
    }

    @Test
    public void submitSampleWithInvalidDataReturns400(TestContext testContext) {
        submitTrainingSample(testContext, new SubmitSampleForm(null, null), 400);
    }

    private void submitTrainingSample(TestContext testContext, SubmitSampleForm formData, int expectedStatusCode) {
        final Async async = testContext.async();

        HttpClientRequest request = vertx.createHttpClient().post(8080, "localhost", "/api/samples", response -> {
            testContext.assertEquals(expectedStatusCode, response.statusCode());
            async.complete();
        });

        String bodyContent = Json.encode(formData);

        request.putHeader("Content-Length", bodyContent.length() + "");
        request.putHeader("Content-Type", "application/json");
        request.end(bodyContent);
    }
}
