package models;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Component {

    protected WebDriver driver;
    protected WebElement component;
    protected WebDriverWait wait;

    public Component(WebDriver driver, WebElement component) {
        this.driver = driver;
        this.component = component;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public <T extends Component> T findComponent(Class<T> componentClass, WebDriver driver){
        return findComponents(componentClass, driver).get(0);
    }

    public WebElement findElement(By by){
        WebElement element = null;
        Exception exception = null;
        try {
            element = component.findElement(by);
        } catch (Exception e){
            exception = e;
            if(e instanceof NoSuchFrameException){
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            }
        }
        if(element == null)
            throw new RuntimeException(exception.toString());
        return element;
    }

    public List<WebElement> findElements(By by){
        return component.findElements(by);
    }

    public <T extends Component> List<T> findComponents(Class<T> componentClass, WebDriver driver){

        Class<?>[] parameters = new Class[] {WebDriver.class, WebElement.class};
        Constructor<T> constructor;
        try {
            constructor = componentClass.getConstructor(parameters);
        } catch (NoSuchMethodException e){
            throw new IllegalArgumentException("The class must have a constructor with parameters" + Arrays.toString(parameters), e);
        }

        String cssSelector = componentClass.getAnnotation(ComponentCssSelector.class).value();
        List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(cssSelector)));

        // return type | name | (params) {}
        // webElement -> {}
        return results.stream().map(webElement -> {
            try{
                return constructor.newInstance(driver, webElement);
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException e){
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }

    public void scrollUptoElement(WebElement element){
        scrollIntoElement("false", element);
    }

    public void scrollDownToElement(WebElement element){
        scrollIntoElement("true", element);
    }

    private void scrollIntoElement(String position, WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(" + position + ");", element);
    }

}
