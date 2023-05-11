package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

//4.DesktopsPage - Desktops text, Sortby, Display, selectProductList Locators and it's actions
public class DesktopsPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[6]/div[3]/div[1]/div[3]/div[1]/div[1]/h1[1]")
    WebElement desktopstext;
    @CacheLookup
    @FindBy(id="products-orderby")
    WebElement sortBy;
    @CacheLookup
    @FindBy(id="products-pagesize")
    WebElement display;

    public String getDesktopsText(){
        Reporter.log("Verify Desktops Title");
        CustomListeners.test.log(Status.PASS,"Verify Desktops Title");
        return getTextFromElement(desktopstext);
    }
    public void sortByDropDown(String text){
        Reporter.log("Select from SortBy list:  "+text);
        CustomListeners.test.log(Status.PASS,"Select from SortBy list:  "+text);
        selectByVisibleTextFromDropDown(sortBy,text);
    }
    public void displayDropDown(String text){
        Reporter.log("Select from Display list:  "+text);
        CustomListeners.test.log(Status.PASS,"Select from Display list:  "+text);
        selectByVisibleTextFromDropDown(display,text);
    }


}
