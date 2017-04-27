package com.xym.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类使用
 *
 *@author xym
 *@create 2017-04-27-16:24
 */
public class AtomicTest {
	public static void main(String[] args) {
		AtomicThread atomicThread = new AtomicThread();

		new Thread(atomicThread).start();
		new Thread(atomicThread).start();
	}
}

class AtomicThread implements Runnable {

	private AtomicInteger count = new AtomicInteger();

	@Override
	public void run() {
		System.out.println(String.format("count++: %s\tthread: %s", count.getAndIncrement(),
				Thread.currentThread().getName()));
	}
}
