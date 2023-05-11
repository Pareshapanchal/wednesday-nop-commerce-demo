package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    HomePage homePage ;
    LoginPage loginPage ;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }
    @Test(groups = {"sanity","regression"},priority = 2)
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        homePage.clickOnLoginLink();
        String expectedText ="Welcome, Please Sign In!";
        String acctualText = loginPage.getWelcomeText();
        Assert.assertEquals(acctualText,expectedText,"Login page not dispalyed");
    }
    @Test(dataProvider = "LoginInvalidCredential",dataProviderClass = TestData.class,groups = {"sanity","regression"},priority = 5)
    public void verifyTheErrorMessageWithInValidCredentials(String email, String password){
        // Click on login link
        homePage.clickOnLoginLink();

        //	 Enter Email  //Enter Password//	 Click on Login Button
        loginPage.loginToApplication(email,password);
        //	 Verify that the Error message
        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage, "Error message not displayed");
    }
    @Test(dataProvider = "LoginWithValidCredential",dataProviderClass = TestData.class,groups = {"smoke","regression"},priority = 3)
     //3. verifyThatUserShouldLogInSuccessFullyWithValidCredentials.
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(String email,String password) {
            //	 Click on login link
        homePage.clickOnLoginLink();
            //	 Enter EmailId  //	 Enter Password  //	 Click on Login Button
        loginPage.loginToApplication(email,password);
            //	 Verify that LogOut link is display
         String actualLogoutText = loginPage.getLogoutText();
         Assert.assertEquals(loginPage.getLogoutText(),"Log out","Login is unsuccessful");
    }
@Test(dataProvider = "LoginWithValidCredential",dataProviderClass = TestData.class,groups = {"regression"},priority = 4)
    //4. VerifyThatUserShouldLogOutSuccessFully()
    public void VerifyThatUserShouldLogOutSuccessFully(String email, String password) {
            //     Click on login link
            homePage.clickOnLoginLink();
            //	 Enter EmailId //	 Enter Password   //	 Click on Login Button
             loginPage.loginToApplication(email,password);
            //	 Click on LogOut Link
            loginPage.clickOnLogoutLink();
            //	 Verify that LogIn Link Display
          Assert.assertEquals(loginPage.getLoginLinkText(),"Log in","not successfully logout");
}
}
