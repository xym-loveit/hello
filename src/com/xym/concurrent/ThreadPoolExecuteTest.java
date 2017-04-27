package com.xym.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-27-18:23
 */
public class ThreadPoolExecuteTest {

	public static void main(String[] args) {

		ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(1);

		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 3, 1, TimeUnit.DAYS,
				blockingQueue);

		poolExecutor.execute(new Runnable() {
			public void run() {
				System.out.println(String.format("任务: %s", Thread.currentThread().getName()));
			}
		});

		poolExecutor.execute(new Runnable() {
			public void run() {
				System.out.println(String.format("任务: %s", Thread.currentThread().getName()));
			}
		});

		poolExecutor.execute(new Runnable() {
			public void run() {
				System.out.println(String.format("任务: %s", Thread.currentThread().getName()));
			}
		});

		System.out.println(String.format("列队中线程数：%s", blockingQueue.size()));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		poolExecutor.shutdown();

	}
}
