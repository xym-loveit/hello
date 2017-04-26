package com.xym.concurrent;

import java.util.concurrent.*;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-25-19:22
 */
public class TestCallAble {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		MyRuner myRuner = new MyRuner("A");
		MyRuner myRuner1 = new MyRuner("B");

		Future<String> future = executorService.submit(myRuner);
		Future<String> future1 = executorService.submit(myRuner1);

		System.out.println("返回值1=" + future.get());
		System.out.println("返回值2=" + future1.get());

		executorService.shutdown();
	}

}

class MyRuner implements Callable {

	private String name;

	public MyRuner(String name) {
		this.name = name;
	}

	@Override
	public Object call() throws Exception {
		return name + " 带返回值,"+Thread.currentThread().getName();
	}
}
