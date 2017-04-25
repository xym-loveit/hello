package com.xym.first;

/**
 *risk
 *@author xym
 *@create 2017-04-25-11:05
 */
public class DeadLockRisk {

	private static class Resource {
		public int value;
	}

	private Resource resourceA = new Resource();
	private Resource resourceB = new Resource();

	public int read(int i) {
		synchronized (resourceA) {
			synchronized (resourceB) {
				System.out.println("read " + i);
				return resourceB.value + resourceA.value;
			}
		}
	}

	public void write(int a, int b, int c) {
		synchronized (resourceB) {
			synchronized (resourceA) {
				System.out.println("write " + c);
				resourceA.value = a;
				resourceB.value = b;
			}
		}
	}

}
