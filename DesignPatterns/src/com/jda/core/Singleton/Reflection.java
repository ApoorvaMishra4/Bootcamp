package com.jda.core.Singleton;

public class Reflection {

    public static void main(String[] args) {
        EagerInitialized instanceOne = EagerInitialized.getInstance();
        EagerInitialized instanceTwo = null;
        try {
            Constructor[] constructors = EagerInitialized.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                ((Object) constructor).setAccessible(true);
                instanceTwo = (EagerInitialized) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

}
