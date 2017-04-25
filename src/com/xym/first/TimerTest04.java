package com.xym.first;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *cs
 *xym_loveit@126.com
 *@author xym
 *@create 2017-04-24-17:26
 */
public class TimerTest04 {

	Timer time;

	public TimerTest04() {
		this.time = new Timer();
		this.time.scheduleAtFixedRate(new TimeTest(), 1000, 2000);
	}

	public static void main(String[] args) {
		new TimerTest04();
	}

	class TimeTest extends TimerTask {

		int count = 0;

		/**
		 * The action to be performed by this timer task.
		 */
		@Override
		public void run() {
			++count;
			if (count == 2) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Date time = new Date(this.scheduledExecutionTime());
			System.out.println(
					"当前时间：" + new Date() + "执行次数：" + count + ",执行线程:" + Thread.currentThread()
							.getName() + ",本次执行该线程的时间：" + time);
		}
	}

}
