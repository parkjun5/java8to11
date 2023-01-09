package me.parkjun5.annotation;

import java.util.Arrays;
import java.util.List;

public class AppBasicAnnotationUse {

    public static void main(@Chicken String[] args) throws @Chicken RuntimeException {
        List<@Chicken String> names = Arrays.asList("parkjun5");

    }

    static class FeelsLikeChicken<@Chicken T> {

        // <C> 타입파라메터 
        // C 타입
        public static <@Chicken C> void print(C c) {
            System.out.println("c = " + c);
        }
    }
}
