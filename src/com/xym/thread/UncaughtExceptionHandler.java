package com.xym.thread;

/**
 *线程非检查异常
 *
 *@author xym
 *@create 2017-05-16-17:39
 */
public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

	public void uncaughtException(Thread t, Throwable e) {

		System.out.println("异常被捕获");
		System.out.printf("Thread id %s\n", t.getId());
		System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
		System.out.printf("Stack Trace :\n");

		e.printStackTrace(System.out);
		System.out.printf("Thread State %s", t.getState());

	}
}
