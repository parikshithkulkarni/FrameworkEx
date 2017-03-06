package PageObjectModels;

import Factories.ReporterFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Parikshith on 3/2/2017.
 */
public class LoginPagePOM {

    @FindBy(how = How.ID, using = "log")
    private WebElement usernameEditText;

    @FindBy(how = How.ID, using = "pwd")
    private WebElement pwdEditText;

    @FindBy(how = How.ID, using = "login")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ajax_loginform\"]/p[1]/strong")
    private WebElement error;

    public boolean isUsernameBoxVisible(){
        if(usernameEditText.isDisplayed()){
            ReporterFactory.getReporter().log("usernameBox is visible");
            return true;
        }
        return false;
    }

    public boolean isUsernameBoxEnabled(){
        if(usernameEditText.isEnabled()){
            ReporterFactory.getReporter().log("usernameBox is clickable");
            return true;
        }
        return false;
    }

    public void setUsernameEditText(String userName){
        if(isUsernameBoxEnabled() && isUsernameBoxVisible()){
            usernameEditText.sendKeys(userName);
        }
        else{
            //Error logging
        }
    }

    public boolean isPasswordVisible(){
        if(pwdEditText.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isPasswordEnabled(){
        if(pwdEditText.isEnabled()){
            return true;
        }
        return false;
    }

    public void setPasswordEditText(String pwd){
        if(isUsernameBoxEnabled() && isUsernameBoxVisible()){
            pwdEditText.sendKeys(pwd);
        }
        else{
            //Error logging
        }
    }

    public boolean isLoginButtonVisible(){
        if(loginButton.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isLoginButtonClickable(){
        if(loginButton.isEnabled()){
            return true;
        }
        return false;
    }

    public void clickLoginButton(){
        if(isUsernameBoxEnabled() && isUsernameBoxVisible()){
            loginButton.click();
        }
        else{
            //Error logging
        }
    }

    public boolean isErrorVisible(){
        if(error.isDisplayed() || error.isEnabled()){
            ReporterFactory.getReporter().log("Error is visible");
            return true;
        }
        return false;
    }
}
