package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkText {
    public static void main(String[] args){
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            // open target page |  https://the-internet.herokuapp.com/login
            driver.get("https://the-internet.herokuapp.com/login");

            WebElement powerByLinkTextElem = driver.findElement(By.linkText("Elemental Selenium"));
            String linkText = powerByLinkTextElem.getText();
            String linkHref = powerByLinkTextElem.getAttribute("href");
            HyberLink hyberLink = new HyberLink(linkHref,linkText);

            System.out.println(hyberLink.text());
            System.out.println(hyberLink.link());
        } finally {
            // Quit driver session
            driver.quit();
        }
    }

    public static class HyberLink {
        private String link;
        private String text;

        public HyberLink(String link, String text) {
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
