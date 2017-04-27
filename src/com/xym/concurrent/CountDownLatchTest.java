package com.xym.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 *CountDownLatch
 *
 *@author xym
 *@create 2017-04-27-17:05
 */
public class CountDownLatchTest {
	private final static CountDownLatch downLatch = new CountDownLatch(2);

	public static void main(String[] args) {
		Thread thread = new Thread() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("任务: %s", Thread.currentThread().getName()));
				downLatch.countDown();
			}
		};

		Thread thread2 = new Thread() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("任务: %s", Thread.currentThread().getName()));
				downLatch.countDown();
			}
		};

		try {
			thread.start();
			thread2.start();

			downLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("任务: %s", Thread.currentThread().getName()));
	}

}
