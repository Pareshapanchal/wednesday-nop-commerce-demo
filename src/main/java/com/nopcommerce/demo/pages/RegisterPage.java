package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 *  6.RegisterPage - Register Text, male female radio, Firstname, lastname, Date of Birth drop downs, email,
 *   Password, Confirm Password, Register Button, "First name is required.","Last name is required.",
 *   "Email is required.","Password is required.", "Password is required." error message,
 *   "Your registration completed" message, "CONTINUE" button
 *   Locators and it's actions
 */
public class RegisterPage extends Utility {
    @CacheLookup
    @FindBy(xpath="//h1[normalize-space()='Register']")
    WebElement registerLink;
    @CacheLookup
    @FindBy(xpath="//h1[normalize-space()='Register']")
    WebElement registerText ;
    @CacheLookup
    @FindBy(xpath = "//input[@value='M']")
    WebElement maleRadiobutton;
    @CacheLookup
    @FindBy(xpath = "//input[@value='F']")
    WebElement femaleRadiobutton;
    @CacheLookup
    @FindBy(xpath="//input[@id='FirstName']")
    WebElement firstNameField ;
    @CacheLookup
    @FindBy(xpath="//input[@id='LastName']")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement dateOfBirthdday;
    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement monthOfBirthdday;
    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement yearOfBirthdday;
    @CacheLookup
    @FindBy(xpath="//input[@id='Email']")
    WebElement emailField;
    @CacheLookup
    @FindBy(xpath="//input[@id='Password']")
    WebElement passwordField ;
    @CacheLookup
    @FindBy(xpath="//input[@id='ConfirmPassword']")
    WebElement confirmPassword ;
    @CacheLookup
    @FindBy(xpath="//button[normalize-space()='Register']")
    WebElement registerButton;
    @CacheLookup
    @FindBy(xpath="//div[@class='result']")
    WebElement registrationCompleteText ;
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[5]/button[1]")
    WebElement registrationButton;
    @CacheLookup
    @FindBy(id="FirstName-error")
    WebElement firstNmRequireText;
    @CacheLookup
    @FindBy(id="LastName-error")
    WebElement lastNmRequireText;
    @CacheLookup
    @FindBy(id="Email-error")
    WebElement emailRequireText;
    @CacheLookup
    @FindBy(id="Password-error")
    WebElement passwordRequireText;
    @CacheLookup
    @FindBy(id="ConfirmPassword-error")
    WebElement confirmPasswordReqText;

    public void clickOnRegisterButton(){
        Reporter.log("Click on Register button" );
        CustomListeners.test.log(Status.PASS,"Click on Register button");
        clickOnElement(registerButton);
    }
    public String getRegisterText(){
        Reporter.log("Get \"Register\" Text" );
        CustomListeners.test.log(Status.PASS,"Get \"Register\" Text");
        return getTextFromElement(registerText);
    }
    public void clickOnMaleRadioButton(){
        Reporter.log("Click on Male radiobutton" );
        CustomListeners.test.log(Status.PASS,"Click on Male radiobutton ");
        clickOnElement(maleRadiobutton);
    }
    public void clickOnFemaleRadioButton(){
        Reporter.log("Click on Female radiobutton" );
        CustomListeners.test.log(Status.PASS,"Click on Female radiobutton ");
        clickOnElement(femaleRadiobutton);
    }
    public void enterFirstNameLastNameField(String firstname,String lastname){
        Reporter.log("Enter FirstName :    "+firstname);
        CustomListeners.test.log(Status.PASS,"Enter FirstName :    "+firstname);
        sendTextToElement(firstNameField,firstname);
        Reporter.log("Enter LastName :      "+lastname);
        CustomListeners.test.log(Status.PASS,"Enter LastName :    "+lastname);
        sendTextToElement(lastNameField,lastname);
    }
    public void enterEmailField(String email){
        Reporter.log("Enter Email: "+email );
        CustomListeners.test.log(Status.PASS,"Enter Email:  "+email);
        sendTextToElement(emailField,email);
    }
    public void enterPasswordAndConfirmPassword(String password,String confirmpassword){
        Reporter.log("Enter Password :     "+password);
        CustomListeners.test.log(Status.PASS,"Enter Password :     "+password);
        sendTextToElement(passwordField,password);

        Reporter.log("Enter Confirm Password :    "+confirmpassword);
        CustomListeners.test.log(Status.PASS,"Enter Confirm Password :     "+confirmpassword);
        sendTextToElement(confirmPassword,confirmpassword);
    }
    public String getRegistrationCompleteText(){
        Reporter.log("Get \"Your registration completed\" text" );
        CustomListeners.test.log(Status.PASS,"Get \"Your registration completed\" text");
        return getTextFromElement(registrationCompleteText); }
    public void selectDateOfBirth(String day,String month,String year){
        Reporter.log("Enter Date of your Date of birth :  "+day);
        CustomListeners.test.log(Status.PASS,"Enter date of your Date of birth :  "+day);
        selectByVisibleTextFromDropDown(dateOfBirthdday,day);

        Reporter.log("Enter Month of your Date of birth :  "+month);
        CustomListeners.test.log(Status.PASS,"Enter Month of your Date of birth :  "+month);
        selectByVisibleTextFromDropDown(monthOfBirthdday,month);

        Reporter.log("Enter Year of your date of birth :  "+year);
        CustomListeners.test.log(Status.PASS,"Enter Year of your Date of birth :  "+year);
        selectByVisibleTextFromDropDown(yearOfBirthdday,year);
    }
    public String getFirstNameRequiredText(){
        return getTextFromElement(firstNmRequireText);
    }
    public String getLastNameRequiredText(){
        return getTextFromElement(lastNmRequireText);
    }public String getEmailRequiredText(){
        return getTextFromElement(emailRequireText);
    }public String getPasswordRequiredText(){
        return getTextFromElement(passwordRequireText);
    }public String getConfirmPasswordRequiredText(){
        return getTextFromElement(confirmPasswordReqText);
    }


}
