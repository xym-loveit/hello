package com.xym;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *共享锁/排它锁
 *
 *@author xym
 *@create 2017-04-27-15:33
 */
public class ReenTrantReadWriteLock {
	public static void main(String[] args) {
		//Info info = new Info();
		//InfoThread infoThread1 = new InfoThread(info);
		//InfoThread infoThread2 = new InfoThread(info);
		//infoThread1.start();
		//infoThread2.start();

		Info2 info = new Info2();
		InfoThread2 infoThread1 = new InfoThread2(info);
		InfoThread2 infoThread2 = new InfoThread2(info);
		infoThread1.start();
		infoThread2.start();
	}

}

class InfoThread extends Thread {

	private Info info;

	public InfoThread(Info info) {
		this.info = info;
	}

	@Override
	public void run() {
		info.test();
	}
}

class InfoThread2 extends Thread {

	private Info2 info2;

	public InfoThread2(Info2 info2) {
		this.info2 = info2;
	}

	@Override
	public void run() {
		info2.test();
	}
}

class Info {
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public void test() {
		try {
			lock.readLock().lock();
			System.out.println(String.format("获得锁: %s\t 时间：%s", Thread.currentThread().getName(),
					System.currentTimeMillis()));
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
	}
}

class Info2 {
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public void test() {
		try {
			lock.writeLock().lock();
			System.out.println(String.format("获得锁: %s\t 时间：%s", Thread.currentThread().getName(),
					System.currentTimeMillis()));
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}
	}
}


