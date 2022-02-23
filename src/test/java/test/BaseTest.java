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
        driver.quit();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {

        // ONLY capture screenshot when test is failed
        if (result.getStatus() == ITestResult.FAILURE) {
            // 1. Method name
            // methodName_yyyy-mm-dd-hh-mm-ss.png
            // Screenshot folder: ./screenshots

            String methodName = result.getName();
            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH) + 1;
            int d = calendar.get(Calendar.DATE);
            int hr = calendar.get(Calendar.HOUR_OF_DAY);
            int sec = calendar.get(Calendar.SECOND);
            String takenDate = y + "-" + m + "-" + d + "-" + hr + "-" + m + "-" + sec;
            String fileLocation = System.getProperty("user.dir") + "/screenshot" + methodName + "_" + takenDate + ".png";

            //2. Take screen shoot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


            try{
                //3. Save
                FileUtils.copyFile(screenshot,new File(fileLocation));
                //4. Attach into allure report
                Path filePath = Paths.get(fileLocation);
                try(InputStream is = Files.newInputStream(filePath)){
                    Allure.addAttachment(methodName, is);
                }catch(Exception e){
                    e.printStackTrace();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}