package com.xym.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-25-16:49
 */
public class ThreadPoolTest {

	public static void main(String[] args) {

		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		//ExecutorService executorService = Executors.newFixedThreadPool(2);
		ExecutorService executorService = Executors.newCachedThreadPool();
		myThread myThread = new myThread();
		myThread myThread2 = new myThread();
		myThread myThread3 = new myThread();
		myThread myThread4 = new myThread();

		executorService.execute(myThread);
		executorService.execute(myThread2);
		executorService.execute(myThread3);
		executorService.execute(myThread4);

		executorService.shutdown();
	}

}

class myThread extends Thread {
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "-->正在执行");
	}
}

