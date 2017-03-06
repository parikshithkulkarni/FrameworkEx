package TestNGListeners;

import Factories.ReporterFactory;
import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * Created by Parikshith on 3/4/2017.
 */
public class SuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite iSuite) {
        ReporterFactory.getReporter().log("Suite Started \n\n\n");
        ReporterFactory.getReporter().startSuite(iSuite.getName()+"\n");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        ReporterFactory.getReporter().log("Suite Started \n\n\n");
        ReporterFactory.getReporter().startSuite(iSuite.getName()+"\n");
    }
}
