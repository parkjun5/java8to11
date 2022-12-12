package me.parkjun5.lamba.v4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {


    public static void main(String[] args) {
        String[] names = {"sejun", "parkjun5", "keesun"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }

    /**
     * 타입::스태틱_메소드,객체or인스터스::메소드
     */
    private static void classMethod() {
        Function<Integer, String> intToString = (i) -> "number" + i;
        UnaryOperator<String> hiV1 = (s) -> "hi_" + s;
        UnaryOperator<String> hiV2 = BasicClass::hi;
        BasicClass basicClass = new BasicClass();

        UnaryOperator<String> hiV3 = basicClass::hello;
        System.out.println("hiV1 = " + hiV1.apply("sejun"));
        System.out.println("hiV2 = " + hiV2.apply("sejun"));
        System.out.println("hiV3 = " + hiV3.apply("sejun"));


        Supplier<BasicClass> supplier = BasicClass::new;
        BasicClass basicClass1 = supplier.get();
        System.out.println("basicClass1 = " + basicClass1);

        Function<String, BasicClass> createWithString = BasicClass::new;
        BasicClass hai = createWithString.apply("hai");
        System.out.println("hai = " + hai);
    }
}
