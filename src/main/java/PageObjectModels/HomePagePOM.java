package PageObjectModels;

import Factories.ReporterFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Parikshith on 3/2/2017.
 */
public class HomePagePOM {

    @FindBy(how = How.CLASS_NAME, using = "account_icon")
    private WebElement myAccountLink;

    public boolean isMyAccountLinkVisible(){
        if(myAccountLink.isDisplayed()){
            ReporterFactory.getReporter().log("My Account is visible");
            return true;
        }
        return false;
    }

    public boolean isMyAccountLinkClickable(){
        if(myAccountLink.isEnabled()){
            ReporterFactory.getReporter().log("My Account is clickable");
            return true;
        }
        return false;
    }

    public void clickMyAccountLink(){
        myAccountLink.click();
    }


}
