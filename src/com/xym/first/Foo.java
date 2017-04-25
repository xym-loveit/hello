package com.xym.first;

/**
 *thread test
 *xym_loveit@126.com
 *@author xym
 *@create 2017-04-25-9:57
 */
public class Foo {
	private int x = 100;

	public int getX() {
		return x;
	}

	public int fix(int y) {
		x = x - y;
		return x;
	}
}
