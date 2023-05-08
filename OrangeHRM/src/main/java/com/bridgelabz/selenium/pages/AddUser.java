package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.readexcel.ReadPropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class AddUser extends ReadPropertiesFile {

    WebDriver driver;

    @FindBy (xpath = "//input[@id='selectedEmployee_value']")
    WebElement EmployeeName;

    @FindBy(xpath = "//input[@id='user_name']")
    WebElement UserName;

    @FindBy(xpath = "//input[@id='password']")
    WebElement pass;

    @FindBy(xpath = "//input[@id='confirmpassword']")
    WebElement confirmPass;

    @FindBy(id = "modal-save-button")
    WebElement button;



   public AddUser(WebDriver driver){
       this.driver = driver;
       PageFactory.initElements(driver,this);
   }


   public void enterEmployeeName() throws InterruptedException {
       EmployeeName.click();
       driver.findElement(By.id(properties.getProperty("EmployeeNameId"))).sendKeys(properties.getProperty("EmployeeName"));
       Thread.sleep(1000);
       UserName.click();
       driver.findElement(By.xpath(properties.getProperty("UserXpath"))).sendKeys(properties.getProperty("Username"));
       Thread.sleep(1000);
   }

   public void HandleEssRoleDropDown() throws InterruptedException {
       WebElement EssRole = driver.findElement(By.id("essrole"));
       Select s = new Select(EssRole);
       s.selectByValue("string:2");
       Thread.sleep(1000);
   }

   public  void HandleSupervisorRole() throws InterruptedException {
       WebElement SupervisorRole = driver.findElement(By.id("supervisorrole"));
       Select s1 = new Select(SupervisorRole);
       s1.selectByValue("string:3");
       Thread.sleep(1000);
   }

   public void HandleAdminRole() throws InterruptedException {
       WebElement AdminRole = driver.findElement(By.id("adminrole"));
       Select s3 = new Select(AdminRole);
       s3.selectByValue("string:48");
       Thread.sleep(1000);
   }

   public void EnterPassWord() throws InterruptedException {
    pass.click();
    driver.findElement(By.xpath(properties.getProperty("passXpath"))).sendKeys(properties.getProperty("password"));
    Thread.sleep(1000);
   }

    public void ConfirmPassWord() throws InterruptedException {
        confirmPass.click();
        driver.findElement(By.xpath(properties.getProperty("ConfirmPassXpath"))).sendKeys(properties.getProperty("ConfirmPass"));
        Thread.sleep(1000);
    }

    public  void  Button() throws InterruptedException {
       button.click();
       Thread.sleep(1000);
    }

    public boolean ToCheckAddedEmployee(){
        boolean flag = false;
        ArrayList<WebElement> list = new ArrayList<>(driver.findElements(By.xpath("//tbody/tr/td[2]")));
        int ItemsInColumn = list.size();
        System.out.println("total no of items in column" + ItemsInColumn);

        for (int i=0; i<ItemsInColumn; i++) {
            System.out.println("Username: " + list.get(i).getText());
            String DataInColumn = list.get(i).getText();
            if (DataInColumn.equalsIgnoreCase("Abhishek")) {
                flag = true;
            }
        }
            return flag;
        }
    }

