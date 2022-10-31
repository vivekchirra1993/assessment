package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage extends TestBase {

    @FindBy(xpath="//a[@id='nav-hamburger-menu']")
    WebElement hamburger_menu;

    @FindBy(xpath="//div[contains(@class,'hmenu-item') and text()='shop by department']")
    WebElement shop_by_department;
    
    @FindBy(xpath= "(//a[contains(@class, 'hmenu-item')]//div[text() = 'see all'])[1]")
    WebElement shop_by_department_seeAll;

    @FindBy(xpath="//a[contains(@class, 'hmenu-item')]//div[text() = 'Computers']")
    WebElement computers_menuItem;

    @FindBy(xpath ="//a[contains(@class,'hmenu-item') and text()='Monitors']")
    WebElement monitor_menuItem;

    //Initialize page objects
    public AmazonHomePage(){
        PageFactory.initElements(driver,this);
    }

    public boolean isHamburgerMenuVisible(){
        return hamburger_menu.isDisplayed();
    }

    public void clickHamburgerMenu(){
        log.info("Click HamburgerMenu");
        hamburger_menu.click();
    }

    public void clickShopByDepartmentSeeAll(){
        log.info("Click Shop By Department See All Option");
        shop_by_department_seeAll.click();
    }
    public void clickComputersMenuItem(){
        log.info("Click Computers menu item");
        computers_menuItem.click();
    }

    public void clickMonitorsMenuItem(){
        log.info("Click Monitors menu item");
        monitor_menuItem.click();
    }

    public void scrollShopByDepartmentElementIntoView(){
        log.info("Scroll Shop by Department element into view");
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",shop_by_department);
    }

    public void scrollComputersElementIntoView(){
        log.info("Scroll Computers element into view");
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",computers_menuItem);
    }
}
