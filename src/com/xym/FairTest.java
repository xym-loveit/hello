package com.xym;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *非公平锁：表示获取锁是随机获得的，先启动的也不能保证一定先获得锁
 *
 *@author xym
 *@create 2017-04-27-14:09
 */
public class FairTest {

	public static void main(String[] args) {
		Bean2 bean = new Bean2(false);
		Job2[] jobs = new Job2[10];

		for (int i = 0; i < 10; i++) {
			jobs[i] = new Job2(bean);
		}

		for (int i = 0; i < 10; i++) {
			new Thread(jobs[i]).start();
		}

	}

}

class Job2 implements Runnable {
	private Bean2 bean;

	public Job2(Bean2 bean) {
		this.bean = bean;
	}

	@Override
	public void run() {
		System.out.println("开始运行线程：" + Thread.currentThread().getName());
		bean.method();
	}
}

class Bean2 {

	private Lock lock;

	public Bean2(boolean fair) {
		this.lock = new ReentrantLock(fair);
	}

	public void method() {
		lock.lock();
		System.out.println("获取锁：" + Thread.currentThread().getName());
		lock.unlock();
	}
}


