package nl.fizzylogic.intentify.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Provides useful utilities for working with collections
 */
public class CollectionUtils {
    private CollectionUtils() {

    }

    /**
     * Creates a list of values
     *
     * @param items Items to store in the list
     * @param <T>   Type of value stored in the list
     * @return A list of values
     */
    @SafeVarargs
    public static <T> List<T> listOf(T... items) {
        List<T> results = new ArrayList<>(items.length);
        Collections.addAll(results, items);

        return results;
    }
}
