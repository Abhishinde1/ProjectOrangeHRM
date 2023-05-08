package com.bridgelabz.selenium.base;

import com.bridgelabz.selenium.readexcel.ReadPropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BaseClass extends ReadPropertiesFile {
    public static WebDriver driver;

    public void initialization(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(properties.getProperty("App_Url"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("App_Url");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public void tearDown() {
        driver.close();
    }

}