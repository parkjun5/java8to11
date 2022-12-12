package me.parkjun5.interfacechange.v2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("parkjun");
        names.add("sejun");
        names.add("parkjun5");
        names.add("foo");
        System.out.println("names = " + names);

//        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
//        names.sort(compareToIgnoreCase.reversed().thenComparing(...));
        System.out.println("names = " + names);

        spliterator(names);
    }

    private static void spliterator(List<String> names) {
        names.forEach(System.out::println);

        Spliterator<String> spliterator = names.spliterator();
        while (spliterator.tryAdvance(System.out::println));

        while (spliterator.tryAdvance(n -> n.equals("sejun"))) {
            System.out.println("spliterator!!!!!");
        }
        Spliterator<String> spliterator1 = names.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        while (spliterator1.tryAdvance(System.out::println));
        System.out.println("======================");
        spliterator2.forEachRemaining(System.out::println);
        names.removeIf(s -> s.startsWith("f"));

        System.out.println("names = " + names);
    }
}
