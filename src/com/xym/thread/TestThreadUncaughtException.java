package com.xym.thread;

/**
 *处理线程的非检查异常
 *
 *@author xym
 *@create 2017-05-16-17:45
 */
public class TestThreadUncaughtException {
	public static void main(String[] args) {

		ThreadA threadA = new ThreadA();
		//threadA.setUncaughtExceptionHandler(new UncaughtExceptionHandler());
		threadA.start();
	}

	private static class ThreadA extends Thread {
		public void run() {
			//非检查异常
			Integer.parseInt("ttt");
		}
	}
}
