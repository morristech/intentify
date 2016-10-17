package nl.fizzylogic.intentify.entities;

import org.junit.Assert;
import org.junit.Test;

public class SubmitSampleFormTests {
    @Test
    public void equalsWithEqualTextAndIntentReturnsTrue() {
        SubmitSampleForm left = new SubmitSampleForm("test", "test");
        SubmitSampleForm right = new SubmitSampleForm("test", "test");

        Assert.assertEquals(left, right);
    }

    @Test
    public void equalsWithEqualTextAndDifferentIntentReturnsFalse() {
        SubmitSampleForm left = new SubmitSampleForm("test", "test1");
        SubmitSampleForm right = new SubmitSampleForm("test", "test2");

        Assert.assertNotEquals(left, right);
    }

    @Test
    public void equalsWithDifferentTextAndEqualIntentReturnsFalse() {
        SubmitSampleForm left = new SubmitSampleForm("test2", "test");
        SubmitSampleForm right = new SubmitSampleForm("test1", "test");

        Assert.assertNotEquals(left, right);
    }

    @Test
    public void equalsWithOtherNullReturnsFalse() {
        SubmitSampleForm left = new SubmitSampleForm("test2", "test");

        Assert.assertFalse(left.equals(null));
    }

    @Test
    public void equalsWithOtherObjectReturnsFalse() {
        SubmitSampleForm left = new SubmitSampleForm("test2", "test");
        String other = "sample";

        Assert.assertNotEquals(left, other);
    }
}
