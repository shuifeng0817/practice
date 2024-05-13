package com.liuDay003;

import java.lang.reflect.InvocationTargetException;

public class Factory {
    private Factory(){

    }
    public static IBook getInstance(String className){
        try {
            Object o = Class.forName(className).getDeclaredConstructor().newInstance();
            if( o instanceof  IBook){
                return (IBook) o;
            }
            return null;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
