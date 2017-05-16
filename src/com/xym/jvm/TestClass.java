package com.xym.jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *desc
 *
 *@author xym
 *@create 2017-05-15-17:26
 */
public class TestClass {
	private int m;

	public int inc() {
		return m + 1;
	}

	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(10);
	}
}
