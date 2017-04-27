package com.xym.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * CyclicBarrier还提供了另一个构造方法除了传递int类型的参数外，还可以传递一个Runnable类型。它的目的是，
 * 当线程的拦截的数量与构造方法的参数相等时，优先执行构造方法里的任务，然后在执行每个线程中await()方法后面的代码
 *
 */
public class CyclicBarrierTest2 {

	public static void main(String[] args) {
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
			public void run() {
				System.out.println("执行时机----" + Thread.currentThread().getName());
			}
		});

		final Thread thread1 = new Thread() {
			public void run() {
				System.out.println("线程--" + Thread.currentThread().getName() + "开始计时");
				for (int i = 5; i > 0; i--) {
					try {
						System.out.println(
								"倒计时--" + i + "--" + Thread.currentThread().getName() + "开始计时--");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println("线程--" + Thread.currentThread().getName() + "结束--");
			}
		};

		final Thread thread2 = new Thread() {
			public void run() {
				System.out.println("线程--" + Thread.currentThread().getName() + "开始计时");
				for (int i = 20; i > 0; i--) {
					try {
						System.out.println(
								"倒计时--" + i + "--" + Thread.currentThread().getName() + "开始计时--");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println("线程--" + Thread.currentThread().getName() + "结束");
			}
		};

		thread1.start();
		thread2.start();

		System.out.println(String.format("任务: %s", Thread.currentThread().getName()));
	}

}