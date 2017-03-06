package DataProviderTest;

import DataProvider.TestDataProviderExcel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Parikshith on 3/2/2017.
 */
public class TestDataProviderTest {

    private TestDataProviderExcel testDataProviderExcel = null;

    @BeforeClass
    public void setup(){

        try {
            testDataProviderExcel = new TestDataProviderExcel("C:\\Users\\parik\\IdeaProjects\\FrameworkEx\\src\\test\\testdata\\test_data.xlsx");
        } catch (IOException e) {
            Assert.assertEquals(false,true,"incorrect file!");
            e.printStackTrace();
        }
    }

    @Test
    public void testUserName(){
        String username = testDataProviderExcel.getUserName("Test001");
        Assert.assertEquals(username,"username1","Incorrect username!");
    }

    @Test
    public void testProductID(){
        String productID = testDataProviderExcel.getProductID("Test001");
        Assert.assertEquals(productID,"1234","Incorrect username!");
    }

}
