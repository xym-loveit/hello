package com.xym;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *根据condition 精确控制线程的wait/notify
 *
 *@author xym
 *@create 2017-04-27-10:35
 */
public class TestAwaitAndSignalAll2 {

	public static void main(String[] args) {

		Test4 test4 = new Test4();

		new Thread(new Await3(test4)).start();
		new Thread(new Await4(test4)).start();

		for (int i = 5; i > 0; i--) {
			System.out.println("倒计时:" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		test4.signalAll1();
	}

}

class Await4 implements Runnable {
	private Test4 test4;

	public Await4(Test4 test4) {
		this.test4 = test4;
	}

	public void run() {
		test4.await1();
	}
}

class Await3 implements Runnable {
	private Test4 test4;

	public Await3(Test4 test4) {
		this.test4 = test4;
	}

	public void run() {
		test4.await2();
	}
}

class Test4 {
	private Lock lock = new ReentrantLock();
	private Condition condition1 = lock.newCondition();
	private Condition condition2 = lock.newCondition();

	public void await1() {
		lock.lock();
		try {
			System.out.println(
					String.format("await1线程开始\tthread: %s", Thread.currentThread().getName()));
			condition1.await();
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
			condition2.await();
			System.out.println(
					String.format("await2线程结束\tthread: %s", Thread.currentThread().getName()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signalAll1() {
		lock.lock();
		System.out.println(
				String.format("signalAll1--恢复所有线程\tthread: %s", Thread.currentThread().getName()));
		condition1.signalAll();
		lock.unlock();
	}

	public void signalAll2() {
		lock.lock();
		System.out.println(
				String.format("signalAll2--恢复所有线程\tthread: %s", Thread.currentThread().getName()));
		condition2.signalAll();
		lock.unlock();
	}
}