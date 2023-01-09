package me.parkjun5.annotation;

import java.util.Arrays;

@Chicken2("양념")
@Chicken2("후라이드")
@Chicken2("마늘간장")
public class AppAnnotationDuplicate {

    public static void main(String[] args) {
        Chicken2[] annotationsByType = AppAnnotationDuplicate.class.getAnnotationsByType(Chicken2.class);

        Arrays.stream(annotationsByType).forEach(c -> System.out.println("c = " + c));

        ChickenContainer annotation = AppAnnotationDuplicate.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(annotation.value()).forEach(System.out::println);
    }
}
