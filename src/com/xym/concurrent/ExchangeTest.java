package com.xym.concurrent;

import java.util.concurrent.Exchanger;

/**
 *Exchanger的作用是可以用来进行线程间数据的交换。线程可以调用Exchanger中的exchange()方法来交换数据。
 * 只有两个线程都调用了exchange()方法数据才会交换，如果只有一个线程执行exchange()方法，那么当前线程就会一直等待，直到有其它线程执行exchange()方法时，线程才会恢复。
 *
 *@author xym
 *@create 2017-04-27-18:04
 */
public class ExchangeTest {

	public static void main(String[] args) {

		final Exchanger<String> exchanger = new Exchanger<String>();

		Thread thread = new Thread() {
			public void run() {

				String value = "xxx";

				for (int i = 5; i > 0; i--) {
					try {
						System.out.println(String.format("倒计时：%s\tthread: %s", i,
								Thread.currentThread().getName()));
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					String result = exchanger.exchange(value);
					System.out.println(
							"线程数据交换结果：" + result + ",thread: " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread thread2 = new Thread() {
			public void run() {

				String value = "yyy";

				for (int i = 10; i > 0; i--) {
					try {
						System.out.println(String.format("倒计时：%s\tthread: %s", i,
								Thread.currentThread().getName()));
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					String result = exchanger.exchange(value);
					System.out.println(
							"线程数据交换结果：" + result + ",thread: " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		thread.start();
		thread2.start();

		System.out.println("~~~~~~~~~~~~~~~main runnging");
	}
}
