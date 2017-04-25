package com.xym.first;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *定时任务
 *@author xym
 *@create 2017-04-24-17:10
 */
public class TimerTest02 {

	Timer timer;

	public TimerTest02() {
		this.timer = new Timer();
		Date time = getTime();
		System.out.println("执行时间:"+time);
		this.timer.schedule(new TimerTest(),time);
	}

	public static void main(String[] args) {
		System.out.println("timer begin...");
		TimerTest02 timerTest01 = new TimerTest02();
		System.out.println(timerTest01.timer.getClass());
	}

	public Date getTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 17);
		calendar.set(Calendar.MINUTE, 25);
		calendar.set(Calendar.SECOND, 0);
		Date time = calendar.getTime();
		return time;
	}

	class TimerTest extends TimerTask {

		/**
		 * The action to be performed by this timer task.
		 */
		@Override
		public void run() {
			System.out.println("指定时间执行任务!!!");
		}
	}

}
