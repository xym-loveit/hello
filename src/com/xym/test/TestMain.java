package com.xym.test;

import java.util.Calendar;

/**
 *desc
 *
 *@author xym
 *@create 2017-05-25-15:33
 */
public class TestMain {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 5, 26, 18, 30);

		System.out.println(calendar.getTime().getTime());

	}
}
