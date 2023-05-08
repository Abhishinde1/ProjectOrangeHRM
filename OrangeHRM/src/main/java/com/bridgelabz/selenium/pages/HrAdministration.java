package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HrAdministration extends BaseClass {

    @FindBy (linkText = "HR Administration")
    WebElement HrAdministrationModule;

    public HrAdministration(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean HrButton () throws InterruptedException {
        HrAdministrationModule.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement tableName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("list")));
        Thread.sleep(2000);
        boolean flag = tableName.isDisplayed();
        return flag;
    }
}
