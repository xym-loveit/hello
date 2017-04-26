package com.xym.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

;

/**
 * desc
 *
 * @author xym
 * @create 2017-04-26 22:42
 */
public class MessageServer implements Runnable {

    List<Object> messages = Collections.synchronizedList(new ArrayList());

    @Override
    public synchronized void run() {

        while (true) {
            if (messages.size() >= 5) {
                System.out.println("当前消息太多，休息10秒...");
                for (int i = 10; i > 0; i--) {
                    System.out.println(String.format("倒计时：%s", i));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            messages.add(new Object());
            System.out.println(String.format("消息服务中已有消息：%s 条 当前线程：%s", messages.size(), Thread.currentThread().getName()));
        }

    }

    public static void main(String[] args) {
        new Thread(new MessageServer()).start();
    }
}