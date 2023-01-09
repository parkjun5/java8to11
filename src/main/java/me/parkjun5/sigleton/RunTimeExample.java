package me.parkjun5.sigleton;

public class RunTimeExample {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("runtime.maxMemory() = " + runtime.maxMemory());
        System.out.println("runtime.freeMemory() = " + runtime.freeMemory());
    }
}
