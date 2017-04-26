package com.xym.thread;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-25-15:40
 */
public class Calculator extends Thread {

	int total = 0;

	public void run() {
		synchronized (this) {
			for (int i = 0; i < 101; i++) {
				total += i;
			}
		}
		//通知所有在此对象上等待的线程
		notifyAll();
	}
}
