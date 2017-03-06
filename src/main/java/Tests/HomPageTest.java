package Tests;

import Factories.BrowserFactory;
import PageObjectModels.HomePagePOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Parikshith on 3/2/2017.
 */
public class HomPageTest {

    @Test(groups = "P1")
    public void verifyLinkVisible(){

        WebDriver driver = BrowserFactory.getBrowser();
        driver.get("http://store.demoqa.com");
        HomePagePOM homePagePOM = PageFactory.initElements(driver,HomePagePOM.class);
        Assert.assertTrue(homePagePOM.isMyAccountLinkClickable()&&homePagePOM.isMyAccountLinkVisible()
                ,"Link is not visible or clickable");
    }

    @Test(groups = "P2")
    public void verifyLoginNavigation(){

        WebDriver driver = BrowserFactory.getBrowser();
        driver.get("http://store.demoqa.com");
        HomePagePOM homePagePOM = PageFactory.initElements(driver,HomePagePOM.class);
        homePagePOM.clickMyAccountLink();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://store.demoqa.com/products-page/your-account/")
                ,"Link is not visible or clickable");
    }
}
