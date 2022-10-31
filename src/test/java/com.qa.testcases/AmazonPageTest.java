package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.AmazonHomePage;
import com.qa.pages.MonitorPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


public class AmazonPageTest extends TestBase {

    AmazonHomePage amazonpage;
    MonitorPage monitorPage;

    public AmazonPageTest(){
        super();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(String browser){
        initialization(browser);
        amazonpage = new AmazonHomePage();
        monitorPage = new MonitorPage();
    }

    @Test(groups={"UI"})
    public void FirstTest(){
            Assert.assertTrue(amazonpage.isHamburgerMenuVisible());
            amazonpage.clickHamburgerMenu();
            amazonpage.scrollShopByDepartmentElementIntoView();
            amazonpage.clickShopByDepartmentSeeAll();
            amazonpage.scrollComputersElementIntoView();
            amazonpage.clickComputersMenuItem();
            amazonpage.clickMonitorsMenuItem();
            String value = monitorPage.checkMonitorsPageUrlValue();
            Assert.assertTrue(value.contains("monitors"));
            monitorPage.clickHPCheckBoxItem();
            monitorPage.sortByHighToLowPrice();
            monitorPage.scrollAndClickSecondPricedItem();
            Assert.assertTrue(monitorPage.checkAboutThisItemSectionIsDisplayed());
            String itemName = monitorPage.displayItemName();
            System.out.println(itemName);
            String price = monitorPage.displayItemPrice();
            System.out.println(price);
            List<WebElement> description = monitorPage.displayItemDescription();
            for (WebElement element: description) {
            System.out.println(element.getText());
        }
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}
