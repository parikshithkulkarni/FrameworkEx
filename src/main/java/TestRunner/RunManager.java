package TestRunner;

import Factories.BrowserFactory;
import Factories.DataProviderFactory;
import Factories.ReporterFactory;
import TestNGListeners.SuiteListener;
import TestNGListeners.TestListener;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Parikshith on 3/3/2017.
 */
public class RunManager {

    public static void main(String[] args) {

        TestNG runner = null;
        List<String> suites = DataProviderFactory.getRunConfigReader().getTestSuites();
        List<String> browsers = DataProviderFactory.getRunConfigReader().getBrowsers();
        SuiteListener suiteListener = new SuiteListener();
        TestListener testListener = new TestListener();

        for(String browser: browsers){

            ReporterFactory.getReporter().log("Starting tests with browser"+browser);
            BrowserFactory.getBrowser(browser);
            runner = new TestNG();
            runner.addListener(suiteListener);
            runner.addListener(testListener);
            runner.setTestSuites(suites);
            runner.run();
            System.out.println("hello");
            BrowserFactory.closeBrowser();
            ReporterFactory.getReporter().log("Starting tests with browser"+browser);
        }
        ReporterFactory.getReporter().stopLogging();
    }
}
