package com.xym.thread;

;

/**
 * desc
 *
 * @author xym
 * @create 2017-04-26 22:58
 */
public class MessageServerForInterrpt3 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            if (i % 5 == 0) {
                if (Thread.currentThread().isInterrupted()) {
                    for (int z = 5; z > 0; z--) {
                        System.out.println(String.format("倒计时：%s", z));
                    }
                }
            }
            System.out.println(String.format("i：%s", i));
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MessageServerForInterrpt3());
        thread.start();
        thread.interrupt();

        System.out.println("停止当前线程");

    }
}