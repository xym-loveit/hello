package com.xym.first;

/**
 *thread test
 *xym_loveit@126.com
 *@author xym
 *@create 2017-04-25-9:58
 */
public class MyRunnable implements Runnable {

	private Foo foo = new Foo();

	public int fix(int y) {
		return foo.fix(y);
	}

	public static void main(String[] args) {
		MyRunnable r = new MyRunnable();
		Thread ta = new Thread(r, "Thread-A");
		Thread tb = new Thread(r, "Thread-B");
		ta.start();
		tb.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			this.fix(30);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " : 当前foo对象的x值= " + foo.getX());
		}

	}
}
