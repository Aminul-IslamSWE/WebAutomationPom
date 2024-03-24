package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.collections.Objects;

public class BaseTest {
    page page;
    @BeforeMethod
    public void setupBrowser(){
        String browserName ="firefox";
        if (Objects.equals(browserName,b:"firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (Objects.equals(browserName,b:"Chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }else if(Objects.equals(browserName,b:"headless")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else{
            System.out.println("Please provide right Browser Name");
        }
        driver.manage().window.maximize();
        driver.get("");
        page=new BasePage(driver);
    }

    @AfterMethod
    public void closeBrowser(){
        String browserName="firefox";
        
    }
}

