package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.buttons.AddButton;
import com.bridgelabz.selenium.dataprovider.DataProviderLogic;
import com.bridgelabz.selenium.pages.AddUser;
import com.bridgelabz.selenium.pages.DashBoard;
import com.bridgelabz.selenium.pages.HrAdministration;
import com.bridgelabz.selenium.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.*;

public class OrangeHrmTest extends BaseClass {
    LoginPage loginPage;
    DashBoard dashboard;

    HrAdministration module;

    AddButton Button;

    AddUser addUser;

    @BeforeMethod
    @Parameters("browserName")
    public void setUp(@Optional("chrome") String browser) {
        initialization(browser);
        loginPage = new LoginPage(driver);
        dashboard = new DashBoard(driver);
        module = new HrAdministration(driver);
        Button = new AddButton(driver);
        addUser = new AddUser(driver);


}
    @Test(priority = 1, dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
    @Epic("smoke test")
    @Feature("Login")
    //@Parameters({"userName","password"})
    public void loginToOrangeHrm(String userName, String Password) throws InterruptedException {
        String loginPageTitle = loginPage.loginToOrangeHrm(userName, Password);
        Thread.sleep(500);
        Assert.assertEquals("Employee Management",loginPageTitle);
    }

    @Test(priority = 2, dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
    @Epic("Functional Test")
    @Feature("DashBoard")
    public void DashboardValidation(String username, String password) throws InterruptedException {
        loginPage.loginToOrangeHrm(username, password);
        Boolean flag = dashboard.homeTestValidation();
        Assert.assertEquals(true,flag);
    }

    @Test(priority = 3,dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
    public void ClickToHrAdministration(String username, String password) throws InterruptedException {
        loginPage.loginToOrangeHrm(username, password);
        module.HrButton();
    }

    @Test(priority = 4,dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
    public void ClickToAddButton(String username, String password) throws InterruptedException {
        loginPage.loginToOrangeHrm(username, password);
        module.HrButton();
        Button.ClickOnAddBtn();
    }

    @Test(priority = 4,dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
    public void EnterName(String username, String password) throws InterruptedException {
        loginPage.loginToOrangeHrm(username, password);
        module.HrButton();
        Button.ClickOnAddBtn();
        addUser.enterEmployeeName();
        addUser.HandleEssRoleDropDown();
        addUser.HandleSupervisorRole();
        addUser.HandleAdminRole();
        addUser.EnterPassWord();
        addUser.ConfirmPassWord();
        addUser.Button();

    }

    @Test(priority = 4,dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
    public void CheckingListCount(String username, String password) throws InterruptedException {
        loginPage.loginToOrangeHrm(username, password);
        module.HrButton();
        addUser.ToCheckAddedEmployee();

    }


    @AfterMethod
    public void browserClose(){
        tearDown();
    }
}
