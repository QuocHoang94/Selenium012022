package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import url.Urls;

import java.util.List;

public class Pracetice implements Urls {
    private static final By figureSel = By.cssSelector(".figure");
    private static final By figureImgSel = By.tagName("img");

    private static final By figureDescSel = By.tagName("h5");
    private static final By figureImgLinkSel = By.tagName("a");


    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(BASE_URL.concat(HOVERS));

            // Find a list of figures on page
            List<WebElement> figureElems = driver.findElements(figureSel);

            // Actions
            Actions actions = new Actions(driver);

            // Verification
            if (figureElems.isEmpty()) {
                throw new RuntimeException("The is no user figure on then page!");
            } else {
                for (WebElement figureElem : figureElems) {
                    actions.moveToElement(figureElem).perform();

                    // Get figure data

                    WebElement figureImgElem = figureElem.findElement(figureImgSel);
                    WebElement figureDescElem = figureElem.findElement(figureDescSel);
                    WebElement figureImgLinkElem = figureElem.findElement(figureImgLinkSel);

                    String figureImgSrc = figureImgElem.getAttribute("src");
                    String figureDesc = figureDescElem.getText();
                    String figureImgLink = figureImgLinkElem.getAttribute("href");

                    // print

                    System.out.println(figureImgSrc);
                    System.out.println(figureDesc);
                    System.out.println(figureImgLink);

                    Thread.sleep(2000);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
