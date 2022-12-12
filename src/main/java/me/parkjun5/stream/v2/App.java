package me.parkjun5.stream.v2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));
        javaClasses.add(new OnlineClass(9, "spring 12 core", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("spring으로 시작하는 수업");
        List<OnlineClass> spring = keesunEvents.stream()
                .map(type -> type.stream()
                        .filter(each -> each.getTitle().startsWith("spring"))
                        .collect(Collectors.toList())
                )
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("spring = " + spring);

        System.out.println("close 되지 않은 수업");
        List<OnlineClass> notClose = springClasses.stream()
                .filter(n -> !n.isClosed())
                .filter(Predicate.not(OnlineClass::isClosed))
                .collect(Collectors.toList());
        System.out.println("notClose = " + notClose);

        System.out.println("수업 이름만 모아서 스트림 만들기");
        List<String> collect = springClasses.stream()
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        keesunEvents.stream()
                .flatMap(Collection::stream)
                .forEach(oc -> System.out.println("oc.getTitle() = " + oc.getTitle()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에서 10개 빼고 최대 10개만");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println("test = " + test);


        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 제목만 모아서 List로 만들기");
        List<String> spring1 = springClasses.stream()
                .map(OnlineClass::getTitle)
                .filter(title -> title.contains("spring"))
                .collect(Collectors.toList());
        System.out.println("spring1 = " + spring1);

    }
}
