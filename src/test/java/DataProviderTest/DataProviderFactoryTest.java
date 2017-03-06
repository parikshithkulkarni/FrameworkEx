package DataProviderTest;

import DataProvider.RunConfigReader;
import DataProvider.TestDataProviderExcel;
import Factories.DataProviderFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Parikshith on 3/2/2017.
 */
public class DataProviderFactoryTest {

    @Test
    public void dataProviderInitTest(){

        RunConfigReader runConfigReader = DataProviderFactory.getRunConfigReader();
        Assert.assertTrue(runConfigReader!=null,"DataProviderFactory returned null runConfigReader");

        TestDataProviderExcel testDataProviderExcel = DataProviderFactory.getTestDataProviderExcel();
        Assert.assertTrue(testDataProviderExcel!=null,"DataProviderFactory returned null testDataProviderExcel");
    }

    @Test
    public void dataProviderInstanceTest(){

        RunConfigReader runConfigReader1 = DataProviderFactory.getRunConfigReader();
        RunConfigReader runConfigReader2 = DataProviderFactory.getRunConfigReader();
        Assert.assertTrue(runConfigReader1.equals(runConfigReader2),"Different instances of " +
                "runConfigReader are being created!");


        TestDataProviderExcel testDataProviderExcel1 = DataProviderFactory.getTestDataProviderExcel();
        TestDataProviderExcel testDataProviderExcel2 = DataProviderFactory.getTestDataProviderExcel();
        Assert.assertTrue(testDataProviderExcel1.equals(testDataProviderExcel2),"Different " +
                "instances of testDataProviderExcel are being created!");

    }
}
