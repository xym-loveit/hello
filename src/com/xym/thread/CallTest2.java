package com.xym.thread;

;import java.util.Date;
import java.util.concurrent.*;

/**
 * desc
 *
 * @author xym
 * @create 2017-04-27 22:36
 */
public class CallTest2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();


        Future<String> future = executorService.submit(new Callable<String>() {
            public String call() throws Exception {
                String msg = "目录创建成功!";
                Thread.sleep(10000);
                return msg;
            }
        });

        System.out.println("thread " + Thread.currentThread().getName() + ",date=" + new Date());
        try {
            System.out.println("result=" + future.get());//调用发生阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("thread " + Thread.currentThread().getName() + ",date=" + new Date());
    }

}