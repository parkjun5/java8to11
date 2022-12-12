package me.parkjun5.interfacechange.v1;

public interface Foo2 {
    /**
     * default 메소드끼리 충돌할 경우
     */
    default void printNameUpperCase() {
        System.out.println("foo2".toUpperCase());
    }
}
