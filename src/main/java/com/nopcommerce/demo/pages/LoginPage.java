package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath ="//body[1]/div[6]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]")
    WebElement loginLlink ;
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText ;
    @CacheLookup
    @FindBy(id="Email")
    WebElement emailField ;
    @CacheLookup
    @FindBy(name="Password")
    WebElement passwordField ;
    @CacheLookup
    @FindBy(xpath="//button[contains(text(),'Log in')]")
    WebElement loginButton ;
    @CacheLookup
    @FindBy(xpath="//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage ;
    @CacheLookup
    @FindBy(xpath="//a[normalize-space()='Log out']")
    WebElement logout;

    public String getWelcomeText(){
        Reporter.log("Get Welcome, Please Sign In! Text" );
        CustomListeners.test.log(Status.PASS,"Get Welcome, Please Sign In! Text");
        return getTextFromElement(welcomeText);
    }
    public void enterEmailId(String email){
        Reporter.log("Enter Email "+ email );
        CustomListeners.test.log(Status.PASS,"Enter email       :       " + email);
        sendTextToElement(emailField,email);
    }
    public void enterPassword(String password){
        Reporter.log("Enter Password " + password);
        CustomListeners.test.log(Status.PASS,"Enter password      :     " +password  );
        sendTextToElement(passwordField,password);
    }
    public void clickOnLonginButton(){
        Reporter.log("Click on Login button" );
        CustomListeners.test.log(Status.PASS,"Click on Login button");
        clickOnElement(loginButton);
    }
    public String getErrorMessage(){
        Reporter.log("Get Error Message" );
        CustomListeners.test.log(Status.PASS,"Get Error Message :  \"Login was unsuccessful. Please correct the errors and try again.\\n\"\n" +
                "                 \"No customer account found\" ");
        return getTextFromElement(errorMessage);
    }
    public void loginToApplication(String username,String password){
        enterEmailId(username);
        enterPassword(password);
        clickOnLonginButton();

    }
    public String getLogoutText(){
        return getTextFromElement(logout);
    }
    public void clickOnLogoutLink(){
        clickOnElement(logout);
    }
    public String getLoginLinkText(){
        return getTextFromElement(loginLlink);
    }

}
