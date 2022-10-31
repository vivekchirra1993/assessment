package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MonitorPage extends TestBase {

    public String checkMonitorsPageUrlValue(){
        try{
            Thread.sleep(5000);
        }catch(Exception e){
            System.out.println("Results page is not dispalyed"+e);
        }
        return driver.getCurrentUrl();
    }

    public void clickHPCheckBoxItem(){
        try{
            log.info("Click HP Checkbox Item");
            JavascriptExecutor je = (JavascriptExecutor) driver;
            WebElement hp_checkbox = driver.findElement(By.xpath("//span[text()='HP']"));
            je.executeScript("arguments[0].click();",hp_checkbox);
            Thread.sleep(5000);
        }catch(Exception e){
            log.error("Error in clicking HP Checkbox "+e.getMessage());
        }
    }

    public void sortByHighToLowPrice(){
        try {
            log.info("Click DropDown option - High to Low");
            WebElement dropdownOption = driver.findElement(By.xpath("//*[@data-action='a-dropdown-button']"));
            //Creating object of an Actions class
            Actions action = new Actions(driver);
            action.moveToElement(dropdownOption).perform();
            action.moveToElement(dropdownOption).click().perform();
            dropdownOption =  driver.findElement(By.xpath("//*[@class='a-dropdown-link' and text()='Price: High to Low']"));
            action.moveToElement(dropdownOption).click().perform();
        }
            catch (Exception e) {
                System.out.println("Error in DropDown selection " + e);
            }
    }

    public void scrollAndClickSecondPricedItem(){
        log.info("Scroll and click second priced item");
        WebElement secondHighestPricedItem = driver.findElement(By.xpath("(//span[@class='a-price'])[2]"));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",secondHighestPricedItem);
        je.executeScript("arguments[0].click();",secondHighestPricedItem);
    }

    public boolean checkAboutThisItemSectionIsDisplayed(){
        log.info("Check about this item section is displayed");
        WebElement itemSection = driver.findElement(By.xpath("//h1[text()=' About this item ']"));
        return itemSection.isDisplayed();
    }

    public String displayItemName() {
        WebElement text = driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(text.getText());
        return text.getText();
    }

    public String displayItemPrice() {
        WebElement price = driver.findElement(By.xpath("(//div[@class='a-box-inner']//span[@class='a-offscreen'])[1]"));
        System.out.println(price.getText());
        return price.getText();
    }

    public List<WebElement> displayItemDescription() {
        List<WebElement> description = driver.findElements(By.xpath("(//div[@id='feature-bullets']//li[not(contains(@class,'aok-hidden'))])"));
        return description;
    }
}
