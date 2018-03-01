package com.java8.sample;

import java.util.concurrent.CompletableFuture;

public class SampleCompletableFuture {
    public static void main(String[] args) {


        System.out.println("task 1");

        //Detached from the main thread, the method doSomethingSlow will be execute in other thread
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> doSomethingSlow());

        stringCompletableFuture.thenAccept(s -> {
            System.out.println(s);
            System.out.println("start task 3"); // it will start only after task 2.
        });

        System.out.println("task X - other task that doesn't depend of task 2 and 3");

        //Just to wait the doSomethingSlow
        stringCompletableFuture.join();

    }

    private static String doSomethingSlow() {
        try {
            Thread.sleep(35000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "task 2";
    }
}
