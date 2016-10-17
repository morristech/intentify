package nl.fizzylogic.intentify.training;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import nl.fizzylogic.intentify.common.EventBusAddresses;
import nl.fizzylogic.intentify.common.MessageCodecs;
import nl.fizzylogic.intentify.entities.SubmitSampleForm;
import nl.fizzylogic.intentify.entities.TrainingSample;
import nl.fizzylogic.intentify.restservice.RestServiceVerticle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class TrainingVerticleTest {
    private Vertx vertx;

    @Before
    public void setUp(TestContext testContext) {
        vertx = Vertx.vertx();
    }

    @After
    public void tearDown(TestContext testContext) {
        vertx.close(testContext.asyncAssertSuccess());
    }

    @Test
    public void submitSampleStoresSample(TestContext testContext) throws Exception {
        Async serviceAsync = testContext.async();

        TrainingSampleService trainingServiceMock = new TrainingSampleService() {
            @Override
            public void storeSample(TrainingSample sample) {
                serviceAsync.complete();
            }
        };

        Async deployAsync = testContext.async();

        vertx.deployVerticle(new TrainingVerticle(trainingServiceMock), result -> deployAsync.complete());
        deployAsync.await();

        SubmitSampleForm formData = new SubmitSampleForm("Test sentence", "test");

        DeliveryOptions deliveryOptions = new DeliveryOptions()
                .setCodecName("submit-sample-form-codec");

        vertx.eventBus().publish(EventBusAddresses.SAMPLE_SUBMISSION, formData, deliveryOptions);

        serviceAsync.await(30000);
    }
}
