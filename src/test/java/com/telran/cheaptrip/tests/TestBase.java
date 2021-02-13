package com.telran.cheaptrip.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    WebDriver driver;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + "with data " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("Passed: test method " + result.getMethod().getMethodName());
        } else {
            logger.error("Failed: test method " + result.getMethod().getMethodName() + "\n");
        }
        logger.info("==============================");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // ChromeOptions options=new ChromeOptions();
        //options.addArguments("--window-size=1920,1200");
        driver = new ChromeDriver();
        driver.get("http://test70.lowcoststrip.com./");
        driver.manage().window().maximize();
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}
