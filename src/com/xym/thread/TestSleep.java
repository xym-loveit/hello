package com.xym.thread;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-25-16:00
 */
public class TestSleep {

	public static void main(String[] args) {
		MyThread1 myThread1 = new MyThread1();
		Thread thread = new Thread(new MyRunnable());
		myThread1.setPriority(10);

		thread.setPriority(1);

		myThread1.start();
		thread.start();

	}

}

class MyThread1 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("线程1第" + i + "次执行！");
			//try {
			//	Thread.sleep(100);
			//} catch (InterruptedException e) {
			//	e.printStackTrace();
			//}
		}
	}
}

class MyRunnable implements Runnable {

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("线程2第" + i + "次执行！");
			Thread.yield();
			//try {
			//	Thread.sleep(100);
			//} catch (InterruptedException e) {
			//	e.printStackTrace();
			//}
		}
	}
}
