package DataProviderTest;

import Factories.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Parikshith on 3/2/2017.
 */
public class BrowserFactoryTest {

    @Test
    public void browserFactoryInitTest(){

        WebDriver driver = BrowserFactory.getBrowser("Chrome");
        Assert.assertTrue(driver!=null,"BrowserFactory returned null driver");
    }

    @Test
    public void browserFactortInstanceTest(){

        WebDriver driver1 = BrowserFactory.getBrowser("IE");
        WebDriver driver2 = BrowserFactory.getBrowser("IE");
        Assert.assertTrue(driver1.equals(driver2),"Different instances of driver are being created!");
    }

}
