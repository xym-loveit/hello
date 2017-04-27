package com.xym;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-27-9:42
 */
public class ShareVariable implements Runnable {

	private static volatile int count = 0;

	@Override
	public synchronized void run() {
		count++;
		System.out.println(
				String.format("count: %s\tthread: %s", count, Thread.currentThread().getName()));
	}

	public static void main(String[] args) {
		new Thread(new ShareVariable()).start();
		new Thread(new ShareVariable()).start();
	}
}
