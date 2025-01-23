package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extentReports;
    private static ExtentSparkReporter sparkReporter;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // This method is executed before any test starts
    @Override
    public void onStart(ITestContext context) {
        // Create an instance of ExtentReports and configure it
        sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");  // Path to save the report
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    // This method is executed after each test starts
    @Override
    public void onTestStart(ITestResult result) {
        // Create an individual test case report
        ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    // This method is executed after each test passes
    @Override
    public void onTestSuccess(ITestResult result) {
        // Mark the test as passed
        extentTest.get().pass("Test passed");
    }

    // This method is executed after each test fails
    @Override
    public void onTestFailure(ITestResult result) {
        // Mark the test as failed and capture a screenshot (optional)
        extentTest.get().fail("Test failed").addScreenCaptureFromPath("screenshot.png");
    }

    // This method is executed after each test is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        // Mark the test as skipped
        extentTest.get().skip("Test skipped");
    }

    // This method is executed after all tests in the class are completed
    @Override
    public void onFinish(ITestContext context) {
        // Write the results to the report
        extentReports.flush();
    }
}