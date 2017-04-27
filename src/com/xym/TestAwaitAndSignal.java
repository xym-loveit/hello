package com.xym;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *使用 lock的Condition 特性实现 wait 和notify
 *
 *@author xym
 *@create 2017-04-27-10:17
 */
public class TestAwaitAndSignal {

	public static void main(String[] args) throws InterruptedException {
		Test2 test2 = new Test2();
		new AwaitThread(test2).start();
		for (int i = 3; i > 0; i--) {
			System.out.println(String.format("倒计时：%s", i));
			Thread.sleep(1000);
		}
		new SignalThread(test2).start();
	}
}

class SignalThread extends Thread {

	private Test2 test;

	public SignalThread(Test2 test) {
		this.test = test;
	}

	public void run() {
		test.signal();
	}
}

class AwaitThread extends Thread {

	private Test2 test;

	public AwaitThread(Test2 test) {
		this.test = test;
	}

	public void run() {
		test.await();
	}
}

class Test2 {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void await() {
		lock.lock();
		System.out.println(String.format("线程开始\tthread: %s", Thread.currentThread().getName()));
		try {
			condition.await();

			System.out.println(String.format("线程结束\tthread: %s", Thread.currentThread().getName()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signal() {
		lock.lock();
		System.out.println(String.format("线程恢复\tthread: %s", Thread.currentThread().getName()));
		condition.signal();
		lock.unlock();
	}
}
