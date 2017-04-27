package com.xym.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *不同的线程池执行机制不同，很有意思
 *
 *@author xym
 *@create 2017-04-27-18:43
 */
public class ExtcutorsTest {

	public static void main(String[] args) {
		//testFix();
		//testSingle();
		testCached();
	}

	/**
	 * 我们知道CachedThreadPool线程池中初始化的空闲线程是0，但是它允许的最大线程数是Integer.MAX_VALUE也就相当于无限大。
	 * 所以我们在提交任务时，因为没有超过允许的最大线程数所以线程池就会为我们创建一个新线程。所以任
	 * 务任务二任务三都是并行执行的
	 *
	 */
	private static void testCached() {
		ExecutorService executorService = Executors.newCachedThreadPool();

		executorService.execute(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("Cache任务1：%s", Thread.currentThread().getName()));
			}
		});

		executorService.execute(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("Cache任务2：%s", Thread.currentThread().getName()));
			}
		});

		executorService.execute(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("Cache任务3：%s", Thread.currentThread().getName()));
			}
		});

		executorService.shutdown();
	}

	/**
	 * 因为SingleThreadExecutor线程池最大的并发数是1，所以当我们提交3个任务时，只有一个会执行另外两个会被添加到队列中，所以执行的结果显示只有一个线程
	 */
	private static void testSingle() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		executorService.execute(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("任务1：%s", Thread.currentThread().getName()));
			}
		});

		executorService.execute(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("任务2：%s", Thread.currentThread().getName()));
			}
		});

		executorService.execute(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("任务3：%s", Thread.currentThread().getName()));
			}
		});

		executorService.shutdown();
	}

	/**
	 * 因为我们只创建了2个线程，所以这个线程池的最大并发数就是2，所以任务一任务二是先同时输出的，任务三是后输出的。
	 * 因为任务三被添加到了队列中，只有其它任务执行完，才会执行队列中的任务
	 */
	private static void testFix() {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.execute(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("任务一：%s", Thread.currentThread().getName()));
			}
		});

		executorService.execute(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("任务二：%s", Thread.currentThread().getName()));
			}
		});

		executorService.execute(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("任务三：%s", Thread.currentThread().getName()));
			}
		});

		executorService.shutdown();
	}
}
