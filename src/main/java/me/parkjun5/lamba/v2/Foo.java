package me.parkjun5.lamba.v2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.*;

public class Foo {

    public static void main(String[] args) {
//        functionTest();
        BiFunction<Integer, Integer, Integer> biFunction = (integer, integer2) -> integer + (integer2 * 2);
        System.out.println(biFunction.apply(1, 2));

        Consumer<Integer> printT = (number) -> System.out.println("number = " + number);

        printT.accept(123);

        Supplier<Integer> get10 = () -> 10;
        System.out.println("get10 = " + get10.get());

        Predicate<String> startsWithParkjun = (s) -> s.startsWith("parkjun");
        System.out.println("startsWithParkjun.test('parkjun5'); = " + startsWithParkjun.test("parkjun5"));

        Predicate<Integer> isOdd = number -> number % 2 != 0;
        System.out.println("isOdd.test(1) = " + isOdd.test(1));
        System.out.println("isOdd.test(2) = " + isOdd.test(2));

        UnaryOperator<Integer> plus5 = number -> number + 5;
        System.out.println("plus5 = " + plus5.apply(2));
        
        IntUnaryOperator plus7 = number -> number + 7;
        System.out.println("plus7.applyAsInt(19) = " + plus7.applyAsInt(19));
        IntFunction<BigDecimal> multiply2 = i -> new BigDecimal(i).multiply(BigDecimal.valueOf(2.1));
        System.out.println("multiply2.apply(3) = " + multiply2.apply(3));

    }





    private static void functionTest() {
        Plus10 plus10 = new Plus10();
        Integer result = plus10.apply(145);
        System.out.println("result = " + result);
        System.out.println("plus10.apply(10) = " + plus10.apply(10));
        System.out.println("plus10.apply(10) = " + plus10.apply(10));
        System.out.println("plus10.apply(10) = " + plus10.apply(10));
        System.out.println("plus10.apply(10) = " + plus10.apply(10));

        Function<Integer, Integer> plus20 = number -> number + 20;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        System.out.println("plus20.apply(20) = " + plus20.apply(20));
        System.out.println("plus20.apply(20) = " + plus20.apply(20));

        Function<Integer, Integer> multiply2AndPlus20 = plus20.compose(multiply2);
        Integer apply = multiply2AndPlus20.apply(3);
        System.out.println("apply = " + apply);

        Function<Integer, Integer> plus20AndMultiply2 = plus20.andThen(multiply2);
        System.out.println("plus20AndMultiply2.apply(3) = " + plus20AndMultiply2.apply(3));
    }
}
