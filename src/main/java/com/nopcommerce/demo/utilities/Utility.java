package com.nopcommerce.demo.utilities;

import com.nopcommerce.demo.browserfactory.ManageBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Utility extends ManageBrowser {
    /*Utility Class extends to ManageDriver for the driver to finding locators
     *All common methods are fixed in the utility Class.*/

    //This method will click on element
    public void clickOnElement(WebElement element){ element.click();
    }
    //This method will get Text from element
    public String getTextFromElement(WebElement element){
        return element.getText();
    }
    // This method will send Text to element
    public void sendTextToElement(WebElement element, String text){
        element.sendKeys(text);
    }
    /*
    This method will return list of web elements
     */
    public List<WebElement> webElements(By by){ return driver.findElements(by);    }
    public void clearTheBox( WebElement element){
        element.sendKeys(Keys.CONTROL+"a");
        element.sendKeys(Keys.DELETE);

    }
    //This method will use to hover mouse on the element
    public void mouseHoverOnElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    // This method will use to hover mouse on element and click
    public void mouseHoverOnElementAndClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    // This method will select text from the dropdown box by using value
    public void selectbyValueFromDropDown(WebElement element, String value){
        new Select(element).selectByValue(value);}
    //This method will select element by providing visible text
    public void selectByVisibleTextFromDropDown(WebElement element, String text){
        new Select(element).selectByVisibleText(text);}
    //This method will select element by providing index
    public void selectByIndexFromDropDown(WebElement element, int index){
        new Select(element).selectByIndex(index);}
    //This method will select the option by contain text
    public void selectByContainsTextFromDropDown(WebElement element, String text){
        List<WebElement> allOptions = new Select(element).getOptions();
        for(WebElement options : allOptions){
            if(options.getText().contains(text)){options.click();}
        }
    }

    //This method will close all the windows
    public void closeAllWindows(List<String> hList, String parentWindow){
        for(String str : hList){
            if(!str.equals(parentWindow)){
                driver.switchTo().window(str).close();
            }
        }
    }
    //This method will switch to parent window
    public void switchToParentWindows(String parentWindowId){
        driver.switchTo().window(parentWindowId);
    }
    public boolean switchToRightWindow(String windowTitle, List<String> hList){
        for(String str: hList){
            String title = driver.switchTo().window(str).getTitle();
            if(title.contains(windowTitle)){
                System.out.println("Found the right window...");
                return true;
            }
        }
        return false;
    }
    //This method will use to wait until Visibility OfElementLocated
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //This method will select the particular element from the list and click on that particular element
    public void selectAndClickOnTheElementFromTheList(List<WebElement> elements, String text) {

        for (WebElement title : elements) {
            if (title.getText().contains(text)) {
                title.click();
                break;
            }
        }
    }
    //this method will store the text from the list of element in the string arraylist
    public List<String> getTheListOfElementFromTheList(List<WebElement> element){
        List<WebElement> productTitles = element;
        List<String> listOfTitle = new LinkedList<>();
        for(int i =0; i<productTitles.size();i++){
            String s = productTitles.get(i).getText();
            listOfTitle.add(s);
        }
        return listOfTitle;
    }


    /* This method will generate random number
     */
    public int generateRandomNumber(){ return (int)(Math.random()*5000 +1); }
    /**
     * This method will generate random string
     */
    public static String getRandomString(int length){
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for(int i=0; i<length; i++){
            int index =(int)(Math.random()*characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
    //*****************************screenshot methods****************************************************************//

    public static void takeScreenShot() {
        String filePath = System.getProperty("user.dir") + "/src/main/java/com/softwaretestingboard/magento/screenshots/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr1, new File(filePath + getRandomString(10) + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/main/java/com/magento/softwaretestingboard/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}
