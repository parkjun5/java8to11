package me.parkjun5.completablefuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class AppRow {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        비동기처리();

    }

    private static void 비동기처리() throws InterruptedException, ExecutionException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world =  getWorld("");
//
//        hello.get();
//        world.get();
        //순서 보장이 되지만 블러킹 두번

        CompletableFuture<String> future = hello.thenCompose(AppRow::getWorld);
        // 의존성이 있는 경우 이렇게 연결
        System.out.println("future = " + future.get());

        // 따로 실행하는 경우

        CompletableFuture<String> future1 = hello.thenCombine(world, (h, w) -> h + " " + w);
        System.out.println("future1 = " + future1.get());

        // 모드 테스크의 결과값의 타입이 같다는 것과 아니면 에러가 안난다는 보장이 없다.
        CompletableFuture.allOf(hello, world)
                .thenAccept(result -> {
                    System.out.println("result = " + result);
                });

        List<CompletableFuture> futures = Arrays.asList(hello, world);

        CompletableFuture<List<Object>> results = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
                .thenApply(v -> {
                    return futures.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList());
                });
        List<Object> objects = results.get();

        for (Object object : objects) {
            System.out.println("object = " + object);
        }
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + "World";
        });
    }
}
