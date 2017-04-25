package com.xym.first;

/**
 *test
 *xym_loveit@126.com
 *@author xym
 *@create 2017-04-25-10:27
 */
public class TestNameList {

	public static void main(String[] args) {
		final NameList nl = new NameList();
		nl.add("aaa");
		class NameDropper extends Thread {
			public void run() {
				String name = nl.removeFirst();
				System.out.println(name);
			}
		}

		Thread t1 = new NameDropper();
		Thread t2 = new NameDropper();
		t1.start();
		t2.start();
	}

}
