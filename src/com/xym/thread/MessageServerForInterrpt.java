package com.xym.thread;

;

/**
 * desc
 *
 * @author xym
 * @create 2017-04-26 22:58
 */
public class MessageServerForInterrpt implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("i: %s", i));
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MessageServerForInterrpt());
        thread.start();
        thread.interrupt();

        System.out.println("停止当前线程");

    }
}