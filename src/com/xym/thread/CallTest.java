package com.xym.thread;

;import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * desc
 *
 * @author xym
 * @create 2017-04-27 22:30
 */
public class CallTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new Callable<String>() {
            public String call() {
                System.out.println("thread " + Thread.currentThread().getName());
                return null;
            }
        });
        System.out.println("thread " + Thread.currentThread().getName());
    }
}