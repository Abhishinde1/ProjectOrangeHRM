package com.bridgelabz.selenium.buttons;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddButton extends BaseClass {

    @FindBy (xpath = "//body/div[@id='wrapper']/div[1]/div[1]/div[2]/section[1]/div[3]/ui-view[1]/div[1]/div[1]/div[1]/a[1]")
    WebElement AddBtn;

    public AddButton(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void ClickOnAddBtn() throws InterruptedException {
        AddBtn.click();
        Thread.sleep(1000);
    }
}
