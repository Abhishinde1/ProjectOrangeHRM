package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard extends BaseClass {
    @FindBy(xpath = "//i[contains(text(),'oxd_home_menu')]")
    WebElement HomeButton;

    public DashBoard(WebDriver driver){
    this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean homeTestValidation(){
        Boolean flag = HomeButton.isDisplayed();
        return flag;
    }
}
