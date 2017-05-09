package com.xym.jvm;

/**
 *线程死锁等待,通过jconsole观察死锁发生时的状态
 *
 *@author xym
 *@create 2017-05-09-22:54
 */
public class SynAddRunable implements Runnable {
	int a, b;

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new SynAddRunable(1, 2)).start();
			new Thread(new SynAddRunable(2, 1)).start();
		}
	}

	public SynAddRunable(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void run() {
		synchronized (Integer.valueOf(a)) {
			synchronized (Integer.valueOf(b)) {
				System.out.println(a + b);
			}
		}

	}
}
