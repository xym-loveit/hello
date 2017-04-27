package com.xym;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-27-9:31
 */
public class ThreadForJoin implements Runnable {

	public void run() {
		System.out.println("任务开始");
		try {
			System.out.println("任务结束");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new ThreadForJoin());
		thread.start();

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("主任务执行");
	}
}
