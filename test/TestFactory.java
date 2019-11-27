import org.junit.Assert;
import org.junit.Test;
import junit.framework.AssertionFailedError;

public class TestFactory {
    @Test
    public void testEquals() {
//        Assert.assertEquals(4, 2 + 2);
        Assert.assertEquals(4, 2 + 2);
    }

    @Test
    public void testNotEquals() {
        Assert.assertTrue(5 == 2 + 2);
    }
}
