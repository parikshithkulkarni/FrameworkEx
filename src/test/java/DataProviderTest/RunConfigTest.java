package DataProviderTest;

import DataProvider.RunConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Parikshith on 3/2/2017.
 * Unit tests to validate runcofigreader class
 */
public class RunConfigTest {

    private RunConfigReader runConfigReader = null;

    @BeforeClass
    public void setup(){
        try {
            runConfigReader = new RunConfigReader("src/test/testdata/frameworkTestdata.properties");
        } catch (IOException e) {
            Assert.assertEquals(false,true,"Not able to open config file");
            e.printStackTrace();
        }
    }

    @Test
    public void testPageLoadTimout(){
        long timeout = runConfigReader.getPageLoadTimeout();
        Assert.assertEquals(timeout,5000,"incorrect data");
    }

    @Test
    public void testImplicitWait(){
        long wait = runConfigReader.getImplicitWait();
        Assert.assertEquals(wait,1500,"incorrect data");
    }

    @Test
    public void testIEServerPath(){
        String ieServerPath = runConfigReader.getIEServerPath();
        Assert.assertEquals(ieServerPath,"\"C:\\Users\\parik\\Desktop\\Grad\\JOB\\Testing\\IEDriverServer.exe\"","incorrect data");
    }

    @AfterClass
    public void close(){
        System.out.println("done!");
    }

}
