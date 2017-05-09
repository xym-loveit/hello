package com.xym.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *desc
 *
 *@author xym
 *@create 2017-05-09-22:36
 */
public class MonitoringTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//reader.readLine();

		createBusyThread();

		//reader.readLine();

		Object lock = new Object();
		createLockThread(lock);



	}

	/**
	 * 线程死循环
	 */
	public static void createBusyThread() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				while (true) {
				}
			}
		}, "testBusyThread");

		thread.start();
	}

	/**
	 * 线程锁等待
	 * @param lock
	 */
	public static void createLockThread(final Object lock) {
		Thread lockThread = new Thread(new Runnable() {
			public void run() {

				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}, "testLockThread");

		lockThread.start();
	}

}
