package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;
//3. ComputerPageTest

public class ComputerPageTest extends BaseTest {
    ComputerPage computerPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        computerPage = new ComputerPage();
    }
    @Test(groups = {"sanity","regression"})
    //1. verifyUserShouldNavigateToComputerPageSuccessfully()
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        //   Click on Computer tab
        computerPage.clickOnComputerFromTopMenu();
        //   Verify "Computer" text
        System.out.println(computerPage.getComputersText());
        //Assert.assertEquals(computerPage);
    }
    @Test(groups = {"smoke","regression"})
    //2. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //   Click on Computer tab
        computerPage.clickOnComputerFromTopMenu();
        //   Click on Desktops link
        computerPage.clickOnDesktopsFromComputerMenu();
        //   Verify "Desktops" text
        Assert.assertEquals(computerPage.getDesktopsText(),"Desktops"," Desktops not displayed");
    }
    @Test(dataProvider ="buildyourowncomputer",dataProviderClass = TestData.class, groups = {"regression"})
    //3. VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram,
    //   String hdd, String os, String software)
    public void VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram,
       String hdd, String os, String software) {
        //   Click on Computer tab
        computerPage.clickOnComputerFromTopMenu();
        //   Click on Desktops link
        computerPage.clickOnDesktopsFromComputerMenu();
        //   Click on product name "Build your own computer"
        computerPage.clickOnBuildYourOwnComputer();
        //   Select processor "processor"
         computerPage.selectProcessor(processor);
        //   Select RAM "ram"
        computerPage.selectRam(ram);
        //   Select HDD "hdd"
        if(hdd.equalsIgnoreCase("320 GB")){
            computerPage.clickOnHDD320GB();
        }else {
            computerPage.clickOnHDD400GB();
        }
        //   Select OS "os"
        if(os.equalsIgnoreCase("Vista Home [+$50.00]"))
        {
            computerPage.clickOnOSVistaHome();
        }else {
            computerPage.clickOnOSVistaPremium();
        }
        //   Select Software "software"
        computerPage.clickOnMicrosoftOffice();
        if(software.equalsIgnoreCase("Microsoft Office [+$50.00]")){
            computerPage.clickOnMicrosoftOffice();
        } else if (software.equalsIgnoreCase("Acrobat Reader [+$10.00]")) {
            computerPage.clickOnAcrobatReader();
        }else {
            computerPage.clickOnTotalCommander();
        }
        //   Click on "ADD TO CART" Button
        computerPage.clickOnAddToCartInBuildyourowncomputerPage();
        //   Verify message "The product has been added to your shopping cart"
        Assert.assertEquals(computerPage.getActualProductAddedMessage(),"The product has been added to your shopping cart","The product has been added to your shopping cart is not displayed");
    }
}
