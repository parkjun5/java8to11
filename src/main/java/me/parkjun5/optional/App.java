package me.parkjun5.optional;

import me.parkjun5.stream.v2.OnlineClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Supplier;

public class App {

    public static void main(String[] args) {
        List<OnlineClassV2> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClassV2(1, "spring boot", true));
        springClasses.add(new OnlineClassV2(2, "spring data jpa", true));
        springClasses.add(new OnlineClassV2(3, "spring mvc", false));
        springClasses.add(new OnlineClassV2(4, "spring core", false));
        springClasses.add(new OnlineClassV2(5, "rest api development", false));

        Optional<OnlineClassV2> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();
        boolean isPresentSpring = optional.isPresent();
        System.out.println("isPresentSpring = " + isPresentSpring);

        Optional<OnlineClassV2> optionalJPa = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("optionalJPa"))
                .findFirst();
        boolean isPresentJpa = optionalJPa.isPresent();
        System.out.println("isPresentJpa = " + isPresentJpa);
        
        optional.ifPresent( oc -> System.out.println("oc.getTitle() = " + oc.getTitle()));
        optionalJPa
                .ifPresentOrElse( oc -> System.out.println("oc.getTitle() = " + oc.getTitle()),
                        () -> System.out.println("EMPTY"));

        OnlineClassV2 onlineClassV2 = optionalJPa.orElse(createNewClasses());
        //orElse 무조건 연산은 일어난다 -> 코드이기 떄문ㅇ

        OnlineClassV2 onlineClassV3 = optionalJPa.orElseGet(App::createNewClasses);
        //orElseGet Supplier 사용 불러오지 않으면 연산 X
        
        OnlineClassV2 onlineClassV4 = optional.orElseThrow(IllegalStateException::new);
        //orElseThrow 없으면 에러 -> 생성자 참조 메소드 레퍼런스?

        Optional<OnlineClassV2> onlineClassV5 = optionalJPa.filter(oc -> oc.getId() > 10);
        System.out.println("onlineClassV5.isEmpty() = " + onlineClassV5.isEmpty());
        //filter 값 필터링 가능 없으면 엠티

        Optional<Integer> onlineClassV6 = optional.map(OnlineClassV2::getId);
        System.out.println("onlineClassV6.isEmpty() = " + onlineClassV6.isEmpty());
        System.out.println("onlineClassV6.get() = " + onlineClassV6.get());
        //map -> 한가지만 가지고

        Optional<Progress> onlineClassV7 = optional.flatMap(OnlineClassV2::getProgress);
        System.out.println("onlineClassV7.isEmpty() = " + onlineClassV7.isEmpty());
        System.out.println("onlineClassV7.get() = " + onlineClassV7.get());
        //리턴값이 Optional일 경우 펴준다.
    }

    private static void whereIsBestPlaceToOptional() {
        OnlineClassV2 spring_boot = new OnlineClassV2(1, "spring boot", true);
        //Supplier<NullPointerException> supplier =  () -> new NullPointerException("null");

        Duration studyDuration = spring_boot.getProgress()
                .orElseThrow(() -> new NullPointerException("null"))// 내부에 Supplier가 숨어 있다.
                .getStudyDuration();
        System.out.println("studyDuration = " + studyDuration);

        // 리턴값으로만 사용하기를 권장한다 (메소드 매개변수 타입, 맵의 키타입, 인스턴스의 필드 타입 전부 nullPointer나 구조가 잘못될 수 있다.)

        //리턴 값으로 널이 넘어가게 하면 안된다. 빈 옵셔널을 보내버린다.
        //Optional<Object> empty = Optional.empty();

        //collection, list, stream , map Array, OPtional은 optional로 감싸지 말것 안 감싸도 된다.
        // 그자체로 비어있는지 아닌지 확인 할 수 있다.

        Optional.of(10);
        //primitive 타입에는 박싱 언박싱 문제가 생겨 성능에 문젝 ㅏ있다.
        OptionalInt.of(10);
        // 권장 사항
    }

    private static OnlineClassV2 createNewClasses() {
        return new OnlineClassV2(10, "New class", false);
    }
}
