package com.xym;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-27-9:49
 */
public class ThreadLocalTest implements Runnable {

	private static volatile int count = 0;

	/**
	 * 每个线程持有一份
	 */
	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

	private static synchronized void count() {
		if (threadLocal.get() == null) {
			threadLocal.set(1);
		} else {
			Integer count = threadLocal.get();
			count++;
			threadLocal.set(count);
		}
		count++;
		System.out.println(
				String.format("count: %s\tthread: %s", count, Thread.currentThread().getName()));
		System.out.println(String.format("localCount: %s\tthread: %s", threadLocal.get(),
				Thread.currentThread().getName()));
	}

	public void run() {
		count();
	}

	public static void main(String[] args) {
		ThreadLocalTest threadLocalTest = new ThreadLocalTest();
		new Thread(threadLocalTest).start();
		new Thread(threadLocalTest).start();
	}
}
