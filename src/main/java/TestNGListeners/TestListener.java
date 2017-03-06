package TestNGListeners;

import Factories.BrowserFactory;
import Factories.ReporterFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by Parikshith on 3/4/2017.
 */
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        ReporterFactory.getReporter().startTest(iTestResult.getTestName()+"\n");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ReporterFactory.getReporter().log("Test Passed"+"\n"+"\n"+"\n");
        ReporterFactory.getReporter().stopTest(iTestResult.getTestName()+"\n");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        BrowserFactory.takeScreenShot(iTestResult.getName());
        ReporterFactory.getReporter().error("Test failed"+"\n"+"\n"+"\n");
        ReporterFactory.getReporter().stopTest(iTestResult.getTestName()+"\n");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
