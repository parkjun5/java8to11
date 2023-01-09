package me.parkjun5.iter;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        int size = 1500;
        int[] numbers = new int[size];

        Random random = new Random();
        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());

        long start = System.nanoTime();
        // Single Thread DualPivot QuickSort
        Arrays.sort(numbers);
        System.out.println("serial sorting took " + (System.nanoTime() - start));

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        start = System.nanoTime();
        // Multi Thread? parallel sort-merge fork join framework?
        Arrays.parallelSort(numbers);
        System.out.println("(parallelSort took = " + (System.nanoTime() - start));
    }
}
