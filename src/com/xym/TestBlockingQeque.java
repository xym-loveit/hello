package com.xym;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * desc
 *
 * @author xym
 * @create 2017-04-25 22:44
 */
public class TestBlockingQeque {

    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>(20);
        for (int i = 0; i < 30; i++) {
            //将指定元素添加到此阻塞栈中，如果没有可用空间，将一直等待（如果有必要）
            blockingDeque.putFirst(i);
            System.out.println("向阻塞栈中添加了元素:" + i);
        }
        System.out.println("程序到此运行结束，即将退出----");
    }

}