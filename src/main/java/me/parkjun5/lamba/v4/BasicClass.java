package me.parkjun5.lamba.v4;

public class BasicClass {

    private  String name;

    public BasicClass() {
    }

    public BasicClass(String name) {
        this.name = name;
    }

    public String hello(String name) {
        return "hello_" + name;
    }

    public static String hi(String name) {
        return "hi_" + name;
    }

    @Override
    public String toString() {
        return "BasicClass{" +
                "name='" + name + '\'' +
                '}';
    }
}
