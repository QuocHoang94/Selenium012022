package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkText {

    public static void main(String[] args) throws InterruptedException {
        // class method | getChromeDriver | WebDriver
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // open target page | https://the-internet.herokuapp.com/login
            driver.get("https://the-internet.herokuapp.com/login");

//            WebElement poweredByLinkTextElem = driver.findElement(By.linkText("Elemental Selenium"));
            WebElement poweredByLinkTextElem = driver.findElement(By.partialLinkText("Elemental"));

            String linkText = poweredByLinkTextElem.getText();
            String linkHref = poweredByLinkTextElem.getAttribute("href");
            HyperLink hyperLink = new HyperLink(linkHref, linkText);

            System.out.println(hyperLink.text());
            System.out.println(hyperLink.link());

        } finally {
            // Quit driver session
            driver.quit();
        }

    }

    public static class HyperLink {
        private String link;
        private String text;

        public HyperLink(String link, String text) {
            this.link = link;
            this.text = text;
        }

        public String link() {
            return link;
        }

        public String text() {
            return text;
        }
    }
}
