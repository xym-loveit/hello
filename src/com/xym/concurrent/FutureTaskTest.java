package com.xym.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *Future<V>代表一个异步执行的操作，通过get()方法可以获得操作的结果，如果异步操作还没有完成，则，get()会使当前线程阻塞。FutureTask<V>实现了Future<V>和Runable<V>。Callable代表一个有返回值得操作。
 *
 *@author xym
 *@create 2017-04-28-10:05
 */
public class FutureTaskTest {
	public static void main(String[] args) {

		Callable callable = new Callable() {
			@Override
			public Object call() throws Exception {
				System.out.println("inside callable");
				Thread.sleep(1000);
				return new Integer(8);
			}
		};

		FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);

		new Thread(futureTask).start();

		try {
			System.out.println("blocking here");
			Integer result = futureTask.get();
			System.out.println(result);
		} catch (InterruptedException ignored) {
		} catch (ExecutionException ignored) {
		}

	}
}
