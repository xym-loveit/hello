package com.xym;

import java.util.Date;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *演示共享锁和排它锁之间也是互斥性
 *
 *@author xym
 *@create 2017-04-27-15:59
 */
public class ReenTrantReadWriteLock2 {

	public static void main(String[] args) {
		LockBean lockBean = new LockBean();
		Thread thread = new Thread(new ReadLockThread(lockBean));
		Thread thread1 = new Thread(new WriteLockThread(lockBean));
		thread.start();
		thread1.start();

		try {
			thread1.join();
			thread.join();

			//Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main execute over! " + new Date());
	}

}

class ReadLockThread implements Runnable {
	private LockBean lockBean;

	public ReadLockThread(LockBean lockBean) {
		this.lockBean = lockBean;
	}

	@Override
	public void run() {
		lockBean.testRead();
	}
}

class WriteLockThread implements Runnable {
	private LockBean lockBean;

	public WriteLockThread(LockBean lockBean) {
		this.lockBean = lockBean;
	}

	@Override
	public void run() {
		lockBean.testWrite();
	}
}

class LockBean {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public void testRead() {
		lock.readLock().lock();
		System.out.println(String.format("获得共享锁: %s\t 时间：%s", Thread.currentThread().getName(),
				new Date()));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
	}

	public void testWrite() {
		lock.writeLock().lock();
		System.out.println(String.format("获得排它锁: %s\t 时间：%s", Thread.currentThread().getName(),
				new Date()));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}
	}
}
