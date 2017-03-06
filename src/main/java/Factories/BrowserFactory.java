package Factories;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Parikshith on 3/2/2017.
 * Creates and maintains the instance of WebDriver
 */
public class BrowserFactory {

    private static WebDriver driver;

    @Parameters(value = "browser")
    public static WebDriver getBrowser(String browserName){

        if(driver == null){

            if(browserName.equalsIgnoreCase("IE")){
                driver = new InternetExplorerDriver();
            }
            else if(browserName.equalsIgnoreCase("Chrome")){
                driver =  new ChromeDriver();
            }
            else if(browserName.equalsIgnoreCase("Firefox")){
                //System.setProperty("webdriver.gecko.driver","C:\\Users\\parik\\Desktop\\Grad\\JOB\\Testing\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
            long  pageLoadTimeOut = DataProviderFactory.getRunConfigReader().getPageLoadTimeout();
            long implicitWait = DataProviderFactory.getRunConfigReader().getImplicitWait();
            driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.MILLISECONDS);
            driver.manage().timeouts().implicitlyWait(implicitWait,TimeUnit.MILLISECONDS);
        }
        return driver;
    }


    public static WebDriver getBrowser(){
        driver = getBrowser("Firefox");
        return driver;
    }

    public static void takeScreenShot(String testcaseName){
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        String filePath = "ScreenShots/"+testcaseName+".png";
        File dest = new File(filePath);
        try {
            FileUtils.copyFile(src,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void closeBrowser(){

        driver.close();
        driver.quit();
        driver  = null;
    }
}
