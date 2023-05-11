package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {
    RegisterPage registerPage;
    HomePage homePage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        registerPage = new RegisterPage();
        homePage = new HomePage();
    }
    @Test(groups = {"sanity","regression"}, priority = 0)
    //1. verifyUserShouldNavigateToRegisterPageSuccessfully()
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //   Click on Register Link
        homePage.clickOnRegisterLink();
        //   Verify "Register" text
        Assert.assertEquals(registerPage.getRegisterText(), "Register", "Register text not displayed");
    }
    @Test(groups = {"smoke","regression"})
    //2. verifyThatFirstNameLastNameEmailOasswordAndConfirmPasswordFieldsAreMandetory()
    public void verifyThatFirstNameLastNameEmailOasswordAndConfirmPasswordFieldsAreMandetory(){

        //   Click on Register Link
        homePage.clickOnRegisterLink();

        //   Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        //   Verify the error message "First name is required."
        Assert.assertEquals(registerPage.getFirstNameRequiredText(),"First name is required.","First name is required. not displayed");
        //   Verify the error message "Last name is required."
        Assert.assertEquals(registerPage.getLastNameRequiredText(),"Last name is required.","Last name is required. not displayed");
        //   Verify the error message "Email is required."
        Assert.assertEquals(registerPage.getEmailRequiredText(),"Email is required.","Email is required. not displayed");
        //   Verify the error message "Password is required."
        Assert.assertEquals(registerPage.getPasswordRequiredText(),"Password is required.","Password is required. not displayed");
        //   Verify the error message "Password is required."
        Assert.assertEquals(registerPage.getConfirmPasswordRequiredText(),"Password is required.","Password is required. not displayed");
    }
    @Test(dataProvider = "registertoaccount",dataProviderClass = TestData.class,groups = {"regression"},priority =1)
    //2. VerifyThatUserShouldCreateAccountSuccessfully()
    public void VerifyThatUserShouldCreateAccountSuccessfully(String gender,String firstname,String lastname,String day,
                                    String month,String year,String email,String password,String confirmpassword ) {
        //   Click on Register Link
        homePage.clickOnRegisterLink();
        //   Select gender "Female"
        if(gender.equalsIgnoreCase("male"))
        {
            registerPage.clickOnMaleRadioButton();
        }
        else {
            registerPage.clickOnFemaleRadioButton();
        }
        //   Enter firstname//   Enter lastname
        registerPage.enterFirstNameLastNameField(firstname,lastname);
        //   Select day //   Select month  //   Select year
        registerPage.selectDateOfBirth(day,month,year);
        //   Enter email
        registerPage.enterEmailField(email);
        //   Enter password  //   Enter Confirm Password
        registerPage.enterPasswordAndConfirmPassword(password,confirmpassword);
        //   Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        //   Verify message "Your registration completed"
        Assert.assertEquals(registerPage.getRegistrationCompleteText(),"Your registration completed","Registration Complete Message not displayed");
    }

}
