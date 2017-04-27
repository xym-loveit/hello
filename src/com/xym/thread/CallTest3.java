package com.xym.thread;

;import java.util.concurrent.*;

/**
 * future
 * cancel()中断一个任务。当参数为false表示如果任务已经执行则不能中断当前任务，当参数为true时表示正在执行的任务也会中断
 *
 * @author xym
 * @create 2017-04-27 22:42
 */
public class CallTest3 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String str = "任务一";
                for (int i = 3; i > 0; i--) {
                    System.out.println("倒计时:" + i);
                    TimeUnit.SECONDS.sleep(1);
                }
                System.out.println("str=" + str);
                return str;
            }
        });

        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(String.format("cancel：%s", future.cancel(false)));
            System.out.println(String.format("future：%s", future.get()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}