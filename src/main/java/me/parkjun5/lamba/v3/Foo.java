package me.parkjun5.lamba.v3;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class Foo {

    public static void main(String[] args) {
//        base();
        Foo foo = new Foo();
        foo.run();
    }

    private static void base() {
        Supplier<Integer> get10 = () -> 10;
        System.out.println("get10.get() = " + get10.get());


        BinaryOperator<Integer> sum = Integer::sum;
        System.out.println("sum.apply(10, 50) = " + sum.apply(10, 50));
    }

    private void run() {
        int baseNumber = 10;

        //로컬 클래스
        class LocalClass {
            int baseNumber = 9999;

            void printBaseNumber() {
                System.out.println("baseNumber = " + baseNumber);
            }
        }

        //익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            int baseNumber = 9999;

            @Override
            public void accept(Integer integer) {
                System.out.println("baseNumber = " + baseNumber);
            }
        };

        //람다
        IntConsumer printInt = value -> {
            //baseNumber 에 final을 안넣었지만 값이 안바뀌는 변수라면 effectivce final이 적용되어
            // 반 final 상태로 들어간다
            //만약 baseNumber++ 같은 것을 넣으면 더이상 final이 아니기 떄문에 에러난다.
            System.out.println("value = " + (value + baseNumber));
        };
        LocalClass localClass = new LocalClass();
        System.out.println("쉐도잉이 일어난다 지역변수들 때문에 전역? 좀더 상위 변수가 가려짐");
        System.out.println("localClass.printBaseNumber(); = ");
        localClass.printBaseNumber();
        System.out.println("integerConsumer.accept(12); = ");
        integerConsumer.accept(12);

        System.out.println("쉐도잉이 일어나지 않음 같은 스코프이기 떄문");
        System.out.println("integerConsumer.accept(12); = ");
        printInt.accept(10);
    }
}
