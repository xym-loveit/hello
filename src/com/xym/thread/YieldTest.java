package com.xym.thread;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-28-9:40
 */
public class YieldTest extends Thread {

	public static void main(String[] args) {
		new YieldTest().start();
	}

	public void run() {
		long startTime = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < 50000000; i++) {
			count = count + (i + 1);
			//Thread.yield();
		}

		long endTime = System.currentTimeMillis();
		System.out.println(
				Thread.currentThread().getId() + "," + this.getId() + ",用时：" + (endTime - startTime)
						+ " 毫秒！");
	}
}
