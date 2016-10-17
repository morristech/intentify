package nl.fizzylogic.intentify.restservice;

import io.vertx.core.eventbus.EventBus;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import nl.fizzylogic.intentify.common.EventBusAddresses;

/**
 * Route that allows users to reset the sample set
 */
public class ResetSamplesRoute {
    /**
     * Initializes a new instance of {@link ResetSamplesRoute}
     */
    private ResetSamplesRoute() {

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
     * Handles the request
     *
     * @param eventBus Event bus to publish the reset event on
     * @param context  Context of the request
     */
    private static void handle(EventBus eventBus, RoutingContext context) {
        eventBus.publish(EventBusAddresses.RESET_SAMPLES, "reset");
        context.response().setStatusCode(202).end();
    }
}
