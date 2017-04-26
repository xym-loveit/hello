package com.xym.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

;

/**
 * desc
 *
 * @author xym
 * @create 2017-04-26 22:51
 */
public class MessageServerForIsAlive implements Runnable {

    List<Object> messages = Collections.synchronizedList(new ArrayList());

    @Override
    public void run() {
        messages.add(new Object());

        System.out.println(String.format("消息服务中已有消息：%s 条 当前线程：%s", messages.size(), Thread.currentThread().getName()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MessageServerForIsAlive serverForIsAlive = new MessageServerForIsAlive();

        Thread thread = new Thread(serverForIsAlive);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("倒计时：%s 线程状态: %s", i, thread.isAlive()));
            Thread.sleep(1000);
        }

    }
}