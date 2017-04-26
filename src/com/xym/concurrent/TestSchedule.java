package com.xym.concurrent;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-25-17:00
 */
public class TestSchedule {

	public static void main(String[] args) {

		ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(
				2);

		scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("~~~~~~~~~~~~~~~~~~~" + Thread.currentThread().getName());
			}
		}, 1000, 2000, TimeUnit.MILLISECONDS);

		scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.err.println(
						"系统当前时间:" + new Date() + ",名字：" + Thread.currentThread().getName());
			}
		}, 2000, 5000, TimeUnit.MILLISECONDS);
	}

}
