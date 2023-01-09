package me.parkjun5.sigleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class App {

    public static void main(String[] args) throws IOException {
        EnumSettings settings1 = EnumSettings.INSTANCE;
        EnumSettings settings2 = EnumSettings.INSTANCE;
//        Enum은 리플릭스에서 안전함
//        whiteshipReflection();


        if (settings1 == settings2) {
            System.out.println("same");
        } else {
            System.out.println("fail");
        }


    }

    private static void serialize(EnumSettings settings1) throws IOException {
        Settings setting3;
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("Seetings.obj"))) {
            out.writeObject(settings1);
        }
        try (ObjectInput input = new ObjectInputStream(new FileInputStream("Seetings.obj"))) {
            try {
                setting3 = (Settings) input.readObject();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static Settings whiteshipReflection() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor<Settings> declaredConstructor = Settings.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Settings settings2 = declaredConstructor.newInstance();
        return settings2;
    }

    private static void myReflection() {
        Object o = Arrays.stream(Settings.class
                .getDeclaredConstructors()).map(c -> {
            c.setAccessible(true);
            try {
                return c.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }).findAny().get();
    }
}
