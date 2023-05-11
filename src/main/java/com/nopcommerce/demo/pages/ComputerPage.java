package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
/**
 *  3.ComputerPage - Comuters text, DesktopsLink, NotebooksLink, SoftwareLink Locators
 *  and create appropriate methods for it.
 */
public class ComputerPage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Computers")
            //xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computerlink ;
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktoplink;
    @CacheLookup
    @FindBy()
    WebElement softwarelink;
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[6]/div[3]/div[1]/div[3]/div[1]/div[1]/h1[1]")
    WebElement computersText;
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[6]/div[3]/div[1]/div[3]/div[1]/div[1]/h1[1]")
    WebElement desktopstext;
    @CacheLookup
    @FindBy(linkText = "Build your own computer")
    WebElement buildYourOwnTitle ;
    @CacheLookup
    @FindBy(xpath="//select[@id='product_attribute_1']")
    WebElement processor ;
    @CacheLookup
    @FindBy(xpath="//select[@id='product_attribute_2']")
    WebElement ram ;
    @CacheLookup
    @FindBy(id="product_attribute_3_6")
    WebElement hdd320GB ;
    @CacheLookup
    @FindBy(id="product_attribute_3_7")
    WebElement hdd400GB ;
    @CacheLookup
    @FindBy(id="product_attribute_4_8")
    WebElement vistaHome ;
    @CacheLookup
    @FindBy(xpath="//input[@id='product_attribute_4_9']")
    WebElement vistaPremium ;
    @CacheLookup
    @FindBy(id="product_attribute_5_10")
    WebElement microsoftOffice;
    @CacheLookup
    @FindBy(id="product_attribute_5_11")
    WebElement acrobatReader;
    @CacheLookup
    @FindBy(id="product_attribute_5_12")
    WebElement totalCommander;
    @CacheLookup
    @FindBy(id="add-to-cart-button-1")
    WebElement addtoCartBuildyourown;
    @CacheLookup
    @FindBy(xpath="//p[@class='content']")
    WebElement productAddedToCartMessage ;
    public void clickOnComputerFromTopMenu(){
        Reporter.log("Click On Computers From Top Menu Bar" );
        CustomListeners.test.log(Status.PASS,"Click On Computers From Top Menu Bar");
        clickOnElement(computerlink); }
    public String getComputersText(){
        Reporter.log("Get Computers Title" );
        CustomListeners.test.log(Status.PASS,"Get Computers Title");
        return getTextFromElement(computersText); }

    public void clickOnDesktopsFromComputerMenu(){
        Reporter.log("Click On Desktops From Computer page" );
        CustomListeners.test.log(Status.PASS,"Click On Desktops From Computer page");
        clickOnElement(desktoplink); }
    public String getDesktopsText(){
        Reporter.log("Get Desktops Title" );
        CustomListeners.test.log(Status.PASS,"Get Desktops Title");
        return getTextFromElement(desktopstext);
    }
    public void clickOnBuildYourOwnComputer(){
        Reporter.log("Click on Build your own computer" );
        CustomListeners.test.log(Status.PASS,"Click on Build your own computer");
        clickOnElement(buildYourOwnTitle);   }
    public void selectProcessor(String processorTitle)
    {
        Reporter.log("Select Processor:  "+processorTitle );
        CustomListeners.test.log(Status.PASS,"select Processor:  "+processorTitle);
        selectByVisibleTextFromDropDown(processor,processorTitle);
    }
    public void selectRam(String ram1){
        Reporter.log("Select Ram:  "+ ram1 );
        CustomListeners.test.log(Status.PASS,"Select Ram: " +ram1);
        selectByVisibleTextFromDropDown(ram,ram1);

    }
    public void clickOnHDD320GB(){
        Reporter.log("Click on HDD 320GB"  );
        CustomListeners.test.log(Status.PASS,"Click on HDD 320GB");
        clickOnElement(hdd320GB);
    }
    public void clickOnHDD400GB(){
        Reporter.log("Click on HDD 400GB" );
        CustomListeners.test.log(Status.PASS,"Click on HDD 400GB");
        clickOnElement(hdd400GB);
    }
    public void clickOnOSVistaHome(){
        Reporter.log("Click on Vista Home [+$50.00]" );
        CustomListeners.test.log(Status.PASS,"Click on Vista Home [+$50.00]");
        clickOnElement(vistaHome);
    }
    public void clickOnOSVistaPremium(){
        Reporter.log("Click on Vista Premium [+$60.00]" );
        CustomListeners.test.log(Status.PASS,"Click on Vista Premium [+$60.00]");
        clickOnElement(vistaPremium);
    }
    public void clickOnMicrosoftOffice(){
        Reporter.log("Click on Microsoft Office [+$50.00]" );
        CustomListeners.test.log(Status.PASS,"Click on Vista Premium [+$60.00]");
        clickOnElement(microsoftOffice);
    }
    public void clickOnAcrobatReader(){
        Reporter.log("Click on Acrobat Reader [+$10.00]" );
        CustomListeners.test.log(Status.PASS,"Click on Acrobat Reader [+$10.00]");
        clickOnElement(acrobatReader);
    }
    public void clickOnTotalCommander(){
        Reporter.log("Click on Total Commander [+$5.00]" );
        CustomListeners.test.log(Status.PASS,"Click on Total Commander [+$5.00]");
        clickOnElement(totalCommander);
    }
    public void clickOnAddToCartInBuildyourowncomputerPage(){
        Reporter.log("Click on ADD TO CART" );
        CustomListeners.test.log(Status.PASS,"Click on ADD TO CART");
        clickOnElement(addtoCartBuildyourown);
    }
    public String getActualProductAddedMessage(){

        Reporter.log("getActualProductAddedMessage" );
        CustomListeners.test.log(Status.PASS,"getActualProductAddedMessage");

        return getTextFromElement(productAddedToCartMessage);
    }
}
