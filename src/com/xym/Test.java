package com.xym;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-27-9:59
 */
public class Test {

	private Lock lock = new ReentrantLock();

	public void test() {
		lock.lock();
		for (int i = 0; i < 10; i++) {
			System.out.println(
					String.format("i: %s\tthread: %s", i, Thread.currentThread().getName()));
		}
		lock.unlock();
	}
}


