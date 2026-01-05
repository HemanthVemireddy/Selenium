package MethodOverriding;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class DemoTest
{
    @Test
    public void testPass() {
        Assert.assertTrue(true);   // This will pass
    }

    @Test
    public void testFail() {
        Assert.assertFalse(false);  // This will fail
    }
}
