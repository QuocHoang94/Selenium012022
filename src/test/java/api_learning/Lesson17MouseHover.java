package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import url.Urls;

import java.util.ArrayList;
import java.util.List;

public class Lesson17MouseHover implements Urls {

    private static final By figureSel = By.cssSelector(".figure");
    private static final By figureImgSel = By.tagName("img");
    private static final By figureDescSel = By.tagName("h5");
    private static final By figureImgLinkSel = By.tagName("a");

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Navigate to the test page
            driver.get(BASE_URL.concat(HOVERS));

            // Find a list of figures on the page
            List<WebElement> figureElems = driver.findElements(figureSel);
            List<FigureData> figureDataList = new ArrayList<>();

            // Actions
            Actions actions = new Actions(driver);

            // Verification
            if (figureElems.isEmpty())
                throw new RuntimeException("[ERR] The is no user figure on then page!");
            else {
                for (WebElement figureElem : figureElems) {

                    // Mouse hover
                    actions.moveToElement(figureElem).perform();

                    // Get figure data
                    WebElement figureImgElem = figureElem.findElement(figureImgSel);
                    WebElement figureDescElem = figureElem.findElement(figureDescSel);
                    WebElement figureImgLinkElem = figureElem.findElement(figureImgLinkSel);

                    String figureImgSrc = figureImgElem.getAttribute("src");
                    String figureDesc = figureDescElem.getText();
                    String figureImgLink = figureImgLinkElem.getAttribute("href");

                    // Out into figureData list
                    FigureData figureData = new FigureData(figureImgSrc, figureDesc, figureImgLink);
                    figureDataList.add(figureData);
                }
            }

            for (FigureData figureData : figureDataList) {
                System.out.println(figureData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static class FigureData {
        private String imgSrc;
        private String imgDesc;
        private String imgLink;

        public FigureData(String imgSrc, String imgDesc, String imgLink) {
            this.imgSrc = imgSrc;
            this.imgDesc = imgDesc;
            this.imgLink = imgLink;
        }

        public String getImgSrc() {
            return imgSrc;
        }

        public String getImgDesc() {
            return imgDesc;
        }

        public String getImgLink() {
            return imgLink;
        }

        @Override
        public String toString() {
            return "FigureData{" +
                    "imgSrc='" + imgSrc + '\'' +
                    ", imgDesc='" + imgDesc + '\'' +
                    ", imgLink='" + imgLink + '\'' +
                    '}';
        }
    }

}
