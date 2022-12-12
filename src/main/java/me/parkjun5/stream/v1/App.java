package me.parkjun5.stream.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("parkjun");
        names.add("sejun");
        names.add("parkjun5");
        names.add("foo");

        //stream은 functional하다 기존 데이터는 안건듬
        //오직 한번만 처리
        // 무제한 일수 있다. Short Circuit으로 제한 가능
        Stream<String> stringStream = names.stream().map(s -> s.toUpperCase());

        //중계 operator vs 종료 operator
        //return stream vs return Something.
        System.out.println("==================");
        //종료 operator오기 전까지 실행 안함.
        //종료 opererator가 무조건 하나 있어야 한다.
        names.stream().map(n -> {
            System.out.println("n = " + n);
            return n.toUpperCase();
        });
        System.out.println("==================");

        List<String> collect = names.stream().map(n -> {
            System.out.println("n = " + n + " " + Thread.currentThread().getName());
            return n.toUpperCase();
        }).collect(Collectors.toList());

        collect.forEach(System.out::println);
        System.out.println("==================");

        // 손쉽게 병렬 처리 가능
        Stream<String> stringStream1 = names.parallelStream();
        List<String> collect1 = stringStream1.map(s -> {
                    System.out.println("s = " + s  + " " + Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .collect(Collectors.toList());
        collect1.forEach(System.out::println);
    }
}
