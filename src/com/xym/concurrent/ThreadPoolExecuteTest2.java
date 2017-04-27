package com.xym.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-27-18:29
 */
public class ThreadPoolExecuteTest2 {

	public static void main(String[] args) {

		ArrayBlockingQueue blockingQueue2 = new ArrayBlockingQueue(1);

		ThreadPoolExecutor poolExecutor2 = new ThreadPoolExecutor(2, 3, 1, TimeUnit.DAYS,
				blockingQueue2);

		poolExecutor2.execute(new Runnable() {
			public void run() {
				System.out.println(String.format("任务1: %s", Thread.currentThread().getName()));
			}
		});

		poolExecutor2.execute(new Runnable() {
			public void run() {
				System.out.println(String.format("任务2: %s", Thread.currentThread().getName()));
			}
		});

		poolExecutor2.execute(new Runnable() {
			public void run() {
				System.out.println(String.format("任务3: %s", Thread.currentThread().getName()));
			}
		});

		poolExecutor2.execute(new Runnable() {
			public void run() {
				System.out.println(String.format("任务4: %s", Thread.currentThread().getName()));
			}
		});

		poolExecutor2.execute(new Runnable() {
			public void run() {
				System.out.println(String.format("任务5: %s", Thread.currentThread().getName()));
			}
		});

		System.out.println(String.format("列队中线程数：%s", blockingQueue2.size()));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		poolExecutor2.shutdown();

	}
}