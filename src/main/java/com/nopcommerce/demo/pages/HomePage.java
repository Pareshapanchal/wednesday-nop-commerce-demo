package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath ="//body[1]/div[6]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]")
    WebElement loginLlink ;
    @CacheLookup
    @FindBy(linkText="Register")
    WebElement registerLink ;

    public void clickOnLoginLink(){
        Reporter.log("Click on Login link" );
        CustomListeners.test.log(Status.PASS,"Click on Login link");
        clickOnElement(loginLlink);
    }
    public void clickOnRegisterLink(){
        Reporter.log("Click on Register link" );
        CustomListeners.test.log(Status.PASS,"Click on Register link");
        clickOnElement(registerLink);
    }


}
