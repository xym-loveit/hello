package com.xym;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *公平锁：表示线程获取锁的顺序是按照线程启动顺序来获取的，即先来先得先进先出
 *
 *@author xym
 *@create 2017-04-27-14:09
 */
public class FairTest2 {

	public static void main(String[] args) {
		Bean2 bean = new Bean2(true);
		Job2[] jobs = new Job2[10];

		for (int i = 0; i < 10; i++) {
			jobs[i] = new Job2(bean);
		}

		for (int i = 0; i < 10; i++) {
			new Thread(jobs[i]).start();
		}

	}

}

class Job implements Runnable {
	private Bean2 bean;

	public Job(Bean2 bean) {
		this.bean = bean;
	}

	@Override
	public void run() {
		System.out.println("开始运行线程：" + Thread.currentThread().getName());
		bean.method();
	}
}

class Bean {

	private Lock lock;

	public Bean(boolean fair) {
		this.lock = new ReentrantLock(fair);
	}

	public void method() {
		lock.lock();
		System.out.println("获取锁：" + Thread.currentThread().getName());
		lock.unlock();
	}
}


