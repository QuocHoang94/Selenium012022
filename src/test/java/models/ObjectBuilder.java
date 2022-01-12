package models;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ObjectBuilder {

    public static <T> T buildObject(Class<T> classType) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        T returnedObject = null;
        Class<?>[] parameters = new Class[]{String.class, Integer.class};
        Constructor<T> constructor;

        try {
            constructor = classType.getConstructor(parameters);
        } catch (NoSuchMethodException e) {
            throw  new IllegalArgumentException("The Class should have a constructor with parameters" + Arrays.toString(parameters),e);
        }

        try{
            return constructor.newInstance("Teo",18);
        }catch( IllegalAccessException | InvocationTargetException | InstantiationException e){
            e.printStackTrace();
        }
        return returnedObject;
    }
}
