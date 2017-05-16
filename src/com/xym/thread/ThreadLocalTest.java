package com.xym.thread;

/**
 *desc
 *
 *@author xym
 *@create 2017-05-16-16:46
 */
public class ThreadLocalTest {

	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 0;
		}
	};

	public ThreadLocal<Integer> getThreadLocal() {
		return threadLocal;
	}

	public Integer getNextSeq() {
		threadLocal.set(threadLocal.get() + 1);
		return threadLocal.get();
	}

	public static void main(String[] args) {

		ThreadLocalTest test = new ThreadLocalTest();
		TestClient testClient1 = new TestClient(test);
		TestClient testClient2 = new TestClient(test);
		TestClient testClient3 = new TestClient(test);

		testClient1.start();
		testClient1.start();
		testClient1.start();

	}

	private static class TestClient extends Thread {

		private ThreadLocalTest threadLocalTest;

		public TestClient(ThreadLocalTest threadLocalTest) {
			this.threadLocalTest = threadLocalTest;
		}

		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.println(
						Thread.currentThread().getName() + "----" + threadLocalTest.getNextSeq());
			}
		}
	}
}
