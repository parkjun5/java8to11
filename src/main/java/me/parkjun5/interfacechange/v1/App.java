package me.parkjun5.interfacechange.v1;

public class App {

    public static void main(String[] args) {
        Foo foo = new DefaultFoo("sejun");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();
    }

}
