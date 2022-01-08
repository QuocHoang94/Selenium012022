package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.util.List;

public class MouseHover implements Urls {

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
            //Actions

            Actions actions = new Actions(driver);

            // Verification
            if (figureElems.isEmpty()) {
                throw new RuntimeException("The is no user figure on then Page!");
            } else {
                for (WebElement figureElem : figureElems) {
                    Actions waitOtPerform = actions.moveToElement(figureElem);
                    waitOtPerform.perform();

                    // Get figure data
                    WebElement figureImgElem = figureElem.findElement(figureImgSel);
                    WebElement figureDescElem = figureElem.findElement(figureDescSel);
                    WebElement figureImgLinkElem = figureElem.findElement(figureImgLinkSel);

                    String figureImgSrc = figureImgElem.getAttribute("src");
                    String figureDesc = figureDescElem.getText();
                    String figureImgLink = figureImgLinkElem.getAttribute("href");

                    // Printout
                    System.out.println(figureImgSrc);
                    System.out.println(figureDesc);
                    System.out.println(figureImgLink);

                    // Out into figureData list

                    FigureData firgureData = new FigureData(figureImgSrc, figureDesc, figureImgLink);
                }

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

        public void setImgSrc(String imgSrc) {
            this.imgSrc = imgSrc;
        }

        public void setImgDesc(String imgDesc) {
            this.imgDesc = imgDesc;
        }

        public void setImgLink(String imgLink) {
            this.imgLink = imgLink;
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
