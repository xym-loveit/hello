package com.xym.jvm;

import java.util.Vector;

/**
 *desc
 *
 *@author xym
 *@create 2017-05-16-14:05
 */
public class ThreadDontSafe {

	//vector为线程安全容器,但在外部多线程的环境下并非线程安全
	private static Vector<Integer> vector = new Vector<Integer>();

	public static void main(String[] args) {

		while (true) {

			for (int i = 0; i < 10; i++) {
				vector.add(i);
			}

			Thread removeThread = new Thread(new Runnable() {
				public void run() {
					for (int i = 0; i < vector.size(); i++) {
						vector.remove(i);
					}
				}
			});

			Thread printThread = new Thread(new Runnable() {
				public void run() {
					for (int i = 0; i < vector.size(); i++) {
						System.out.println(vector.get(i));
					}
				}
			});

			printThread.start();
			removeThread.start();

			//不要同时过多的产生线程，否则操作系统会假死
			while (Thread.activeCount() > 20) {
				System.err.println("Thread.activeCount()=" + Thread.activeCount());
			}
		}

	}

}
