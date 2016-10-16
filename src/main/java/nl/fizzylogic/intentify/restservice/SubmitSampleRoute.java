package nl.fizzylogic.intentify.restservice;

import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import nl.fizzylogic.intentify.entities.FieldError;
import nl.fizzylogic.intentify.entities.ValidationError;
import nl.fizzylogic.intentify.common.EventBusAddresses;
import nl.fizzylogic.intentify.entities.SubmitSampleForm;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Handles submission of sample data through HTTP
 */
public final class SubmitSampleRoute {
    private SubmitSampleRoute() {

    }

    /**
     * Binds the route to the router
     *
     * @param router   Router to bind to
     * @param eventBus Event bus to use for this route
     */
    public static void bind(Router router, EventBus eventBus) {
        router.post("/api/samples")
                .consumes("application/json")
                .handler(message -> handle(eventBus, message));
    }

    /**
     * Handles the incoming request data
     *
     * @param context The context for the incoming request
     */
    private static void handle(EventBus eventBus, RoutingContext context) {
        SubmitSampleForm form = Json.decodeValue(context.getBodyAsString(), SubmitSampleForm.class);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<SubmitSampleForm>> violations = validator.validate(form);

        if(!violations.isEmpty()) {
            List<FieldError> errorMessages = violations.stream()
                    .map(violation -> new FieldError(violation.getPropertyPath().toString(), violation.getMessage()))
                    .collect(Collectors.toList());

            context.response()
                    .setStatusCode(400)
                    .end(Json.encodePrettily(new ValidationError(errorMessages)));

            return;
        }

        eventBus.publish(EventBusAddresses.SAMPLE_SUBMISSION, form,
                new DeliveryOptions().setCodecName("submit-sample-form-codec"));

        context.response().setStatusCode(202).end();
    }
}
