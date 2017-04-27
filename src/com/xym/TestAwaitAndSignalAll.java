package com.xym;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-27-10:35
 */
public class TestAwaitAndSignalAll {

	public static void main(String[] args) {

		Test3 test3 = new Test3();

		new Thread(new Await1(test3)).start();
		new Thread(new Await2(test3)).start();

		for (int i = 5; i > 0; i--) {
			System.out.println("倒计时:" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		test3.signalAll();
	}

}

class Await1 implements Runnable {
	private Test3 test3;

	public Await1(Test3 test3) {
		this.test3 = test3;
	}

	public void run() {
		test3.await1();
	}
}

class Await2 implements Runnable {
	private Test3 test3;

	public Await2(Test3 test3) {
		this.test3 = test3;
	}

	public void run() {
		test3.await2();
	}
}

class Test3 {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void await1() {
		lock.lock();
		try {
			System.out.println(
					String.format("await1线程开始\tthread: %s", Thread.currentThread().getName()));
			condition.await();
			System.out.println(
					String.format("await1线程结束\tthread: %s", Thread.currentThread().getName()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void await2() {
		lock.lock();
		try {
			System.out.println(
					String.format("await2线程开始\tthread: %s", Thread.currentThread().getName()));
			condition.await();
			System.out.println(
					String.format("await2线程结束\tthread: %s", Thread.currentThread().getName()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signalAll() {
		lock.lock();
		System.out.println(String.format("恢复所有线程\tthread: %s", Thread.currentThread().getName()));
		condition.signalAll();
		lock.unlock();
	}
}