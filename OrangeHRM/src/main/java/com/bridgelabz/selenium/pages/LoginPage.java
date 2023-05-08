package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    @FindBy(xpath = "//input[@id='txtUsername']")
    WebElement Username;

    @FindBy(xpath = "//input[@id='txtPassword']")
    WebElement Password;

    @FindBy(xpath = "//body/div[@id='wrapper']/div[@id='content']/div[@id='divLogin']/div[2]/div[1]/form[1]/div[3]/button[1]")
    WebElement LoginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String loginToOrangeHrm(String name, String pass) throws InterruptedException {
        Username.sendKeys(name);
        Thread.sleep(500);
        Password.sendKeys(pass);
        Thread.sleep(500);
        LoginBtn.click();
        String LogInTitle = driver.getTitle();
        return LogInTitle;
    }
}
