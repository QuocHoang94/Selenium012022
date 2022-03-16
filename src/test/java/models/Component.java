package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Component {

    protected WebDriver driver;
    protected WebElement component;

    public Component(WebDriver driver, WebElement component) {
        this.driver = driver;
        this.component = component;
    }

    public <T extends Component> T findComponent(Class<T> componentClass, WebDriver driver){
        return findComponents(componentClass, driver).get(0);
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
        List<WebElement> results = component.findElements(By.cssSelector(cssSelector));

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

}
