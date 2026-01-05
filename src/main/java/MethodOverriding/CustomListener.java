package MethodOverriding;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener
{
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test Failed: " + result.getName());
    }
}

/*
onTestFailure() and onTestSuccess() are methods from ITestListener.
In CustomListener, we override them with our own logic (print, log, take screenshot, etc.).
When tests run → TestNG calls the overridden methods, not the default empty ones.
 */
