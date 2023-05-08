package com.bridgelabz.selenium.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderLogic {

    @org.testng.annotations.DataProvider(name = "dataProvider")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"Admin", "IikAB@3d8J"},
        };
    }
}