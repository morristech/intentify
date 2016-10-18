package nl.fizzylogic.intentify.common;

import org.junit.Test;

import static nl.fizzylogic.intentify.common.CollectionUtils.listOf;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class CollectionUtilTest {
    @Test
    public void listOfSetOfItemsReturnsAList() {
        assertThat(
                listOf("test 1", "test 2", "test 3"),
                hasItems("test 1", "test 2", "test 3"));
    }

    @Test
    public void listOfEmptyItemsReturnsEmptyList() {
        assertThat(listOf(), hasItems());
    }
}
