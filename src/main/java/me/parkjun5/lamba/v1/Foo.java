package me.parkjun5.lamba.v1;

public class Foo {

    public static void main(String[] args) {

//        runSomethingV1();
        runSomethingV2();
    }

    public static void runSomethingV1() {
        //  익명 내부 클래스
        RunSomThing runSomThingV1 = new RunSomThing() {
            @Override
            public void doIt() {
                System.out.println("Hello");
            }
        };

        //  람다 사용 표현식
        RunSomThing runSomThingV2 = () -> System.out.println("Hello");


        runSomThingV2.doIt();
    }

    public static void runSomethingV2() {
        RunSomThingV2 runSomThingV2 = (number) -> number + 10;
        //함수형 프로그램을 사용한다는 것 -> 같은 값을 넣으면 언제나 같은 겱ㄹ과
        System.out.println("result must same = " + runSomThingV2.doIt(3));
        System.out.println("result must same = " + runSomThingV2.doIt(3));
        System.out.println("result must same = " + runSomThingV2.doIt(3));
        System.out.println("result must same = " + runSomThingV2.doIt(3));
        System.out.println("result must same = " + runSomThingV2.doIt(3));

    }

    public static void changeResult() {
        final int baseNumber = 10;

        RunSomThingV2 runSomThingV2 = new RunSomThingV2() {
            @Override
            public int doIt(int number) {
                return number + baseNumber;
            }
        };



        RunSomThingV2 runSomThingV3 = number -> number + baseNumber;

    }


}
