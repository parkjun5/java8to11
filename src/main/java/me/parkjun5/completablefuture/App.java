package me.parkjun5.completablefuture;

import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        forkJoinPool();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello supplyAsync " + Thread.currentThread().getName());
            return "parkjun5";
        }, executorService).thenRunAsync(() -> {
            System.out.println("thenRun ss.toUpperCase() " + Thread.currentThread().getName());
        }, executorService);

        voidCompletableFuture.get();
    }

    private static void forkJoinPool() throws InterruptedException, ExecutionException {
        //        기존방식();
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("parkjun5");

        System.out.println("future.get() = " + future.get());

        CompletableFuture<String> futureStatic = CompletableFuture.completedFuture("parkjun Static methond");
        System.out.println("futureStatic = " + futureStatic.get());

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
        });
        voidCompletableFuture.get();


        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello supplyAsync " + Thread.currentThread().getName());
            return "parkjun5";
        }).thenApply((s) -> {
            System.out.println("thenApply s.toUpperCase() = " + s.toUpperCase());
            return s.toUpperCase();
        });

        System.out.println("supplyAsync.get() = " + supplyAsync.get());


        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello supplyAsync " + Thread.currentThread().getName());
            return "parkjun5";
        }).thenAccept((s) -> {
            System.out.println("thenAccept ss.toUpperCase() = " + s.toUpperCase());
        });

        voidCompletableFuture1.get();

        CompletableFuture<Void> voidCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello supplyAsync " + Thread.currentThread().getName());
            return "parkjun5";
        }).thenRun(() -> {
            System.out.println("thenRun ss.toUpperCase()");
        });

        voidCompletableFuture2.get();
    }

    private static void 기존방식_Future_사용() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> future = executorService.submit(() -> "hello");

        System.out.println("future.get() = " + future.get());
    }
}
