package com.xym.jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *Atomic 变量自增测试
 *
 *@author xym
 *@create 2017-05-16-14:31
 */
public class AtomicTest {

	public static void main(String[] args) {

		Thread[] threads = new Thread[THREAD_COUNT];
		for (int i = 0; i < THREAD_COUNT; i++) {
			threads[i] = new Thread(new Runnable() {
				public void run() {
					for (int j = 0; j < 1000; j++) {
						increase();
					}
				}
			});

			threads[i].start();
		}

		while (Thread.activeCount() > 1) {
			Thread.yield();
		}

		System.out.println("race=" + atomicInteger);

	}

	public static AtomicInteger atomicInteger = new AtomicInteger(0);

	private final static int THREAD_COUNT = 20;

	public static void increase() {
		atomicInteger.incrementAndGet();
	}

}
