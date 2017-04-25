package com.xym.first;

/**
 *test
 *
 *@author xym
 *@create 2017-04-25-11:10
 */
public class TestDeadLockRisk {

	static int count=100;

	public static void main(String[] args) {

		final DeadLockRisk testDeadLockRisk = new DeadLockRisk();

		new Thread() {
			public void run() {
				for (int i = 0; i < count; i++) {
					testDeadLockRisk.write(1, 2,i);
				}
			}
		}.start();

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");

		new Thread() {
			public void run() {
				for (int i = 0; i < count; i++) {
					System.out.println(testDeadLockRisk.read(i));
				}
			}
		}.start();

	}

}
