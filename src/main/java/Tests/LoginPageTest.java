package Tests;

import Factories.BrowserFactory;
import Factories.DataProviderFactory;
import PageObjectModels.HomePagePOM;
import PageObjectModels.LoginPagePOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Parikshith on 3/2/2017.
 */
public class LoginPageTest {

    String testCaseName = "Test";

    @Test(groups = "P1")
    public void invalidLoginTest(){
        String completeTestcaseName = testCaseName+"001";
        WebDriver driver = BrowserFactory.getBrowser();
        driver.get("http://store.demoqa.com");

        HomePagePOM homePagePOM = PageFactory.initElements(driver,HomePagePOM.class);
        homePagePOM.clickMyAccountLink();

        LoginPagePOM loginPagePOM = PageFactory.initElements(driver,LoginPagePOM.class);

        String username = DataProviderFactory.getTestDataProviderExcel().getUserName(completeTestcaseName);
        String pwd = DataProviderFactory.getTestDataProviderExcel().getPassword(completeTestcaseName);

        loginPagePOM.setUsernameEditText(username);
        loginPagePOM.setPasswordEditText(pwd);
        loginPagePOM.clickLoginButton();

       // WebDriverWait wait = new WebDriverWait(driver,10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ajax_loginform\"]/p[1]/strong")));
        Assert.assertTrue(loginPagePOM.isErrorVisible(),"Valid username & password!");
    }

}
