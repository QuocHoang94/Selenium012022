package models.pages;

import models.ComponentCssSelector;

public class AnnotationParser {

    public static <T> String printAnnotationValue(Class<T> classType) {
        String componentCssSelector = null;
        try {
            componentCssSelector = classType.getAnnotation(ComponentCssSelector.class).value();
        } catch (Exception ignored) {}
        if(componentCssSelector == null)
        throw new IllegalArgumentException("[ERR] Please provide @ComponentCssSelector");

        return componentCssSelector;
    }

    public static void main(String[] args) {}
}
