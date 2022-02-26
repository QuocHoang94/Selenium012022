package test;

import driver.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BaseTest {

    protected WebDriver driver;

    private void initDriver() {
        driver = DriverFactory.getChromeDriver();
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        initDriver();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
//        driver.quit();
    }


}