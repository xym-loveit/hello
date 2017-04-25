package com.xym;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * desc
 *
 * @author xym
 * @create 2017-04-25 22:33
 */
public class BlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<String>(20);
        for (int i = 0; i < 30; i++) {
            strings.put(i + "");
            System.out.println("向阻塞队列中添加了元素:" + i);
        }

        System.out.println("程序到此运行结束，即将退出----");
    }
}