package com.xym;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-27-10:00
 */
public class ReentrantTest implements Runnable {
	private Test test;

	public ReentrantTest(Test test) {
		this.test = test;
	}

	@Override
	public void run() {
		test.test();
	}

	public static void main(String[] args) {
		Test test = new Test();
		ReentrantTest reentrantTest = new ReentrantTest(test);
		new Thread(reentrantTest).start();
		new Thread(reentrantTest).start();

	}
}
