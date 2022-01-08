package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import url.Urls;

import java.util.List;

public class Practive2 implements Urls {

    private static final By figureContent = By.cssSelector(".figure");
    private static final By figureImg = By.tagName("img");
    private static final By figureH5 = By.tagName("h5");
    private static final By figureLink = By.tagName("a");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(BASE_URL.concat(HOVERS));
            Actions actions = new Actions(driver);

            List<WebElement> figureElements = driver.findElements(figureContent);
            if (figureElements.isEmpty()) {
                throw new RuntimeException("Err");
            } else {
                for (WebElement figureElement : figureElements) {
                    actions.moveToElement(figureElement).perform();

                    WebElement Img = figureElement.findElement(figureImg);
                    WebElement H5 = figureElement.findElement(figureH5);
                    WebElement Link = figureElement.findElement(figureLink);

                    String x = Img.getAttribute("src");
                    String y = H5.getText();
                    String z = Link.getAttribute("href");

                    System.out.println(x);
                    System.out.println(y);
                    System.out.println(z);

                    Thread.sleep(3000);


                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
