package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends page{
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public WebElement getWebElement(By locator) {
        WebElement WebElement = null;
        try {
            waitForWebElement(locator);
            WebElement= driver.findElement(locator);

        }catch (Exception exception){
            System.out.println(locator.toString() +"Select or locator Not Found");
        }
        return WebElement;
    }

    @Override
    public List<WebElement> getWebElements(By selector) {
        List<WebElement>webElement = null;
        try {
            waitForWebElement(selector);
            webElement=driver.findElements(selector);
        }catch (Exception exception){
            System.out.println(selector.toString() +"Select or locator Not Found");
        }

        return webElement;
    }

    @Override
    public void waitForWebElement(By locator) {

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        }catch (Exception exception){
            System.out.println(locator.toString() +"Select or locator Not Found");
        }
    }
}
