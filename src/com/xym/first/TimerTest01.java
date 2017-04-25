package com.xym.first;

import java.util.Timer;
import java.util.TimerTask;

/**
 *定时任务
 *@author xym
 *@create 2017-04-24-17:10
 */
public class TimerTest01 {

	Timer timer;

	public TimerTest01(int time) {
		this.timer = new Timer();
		this.timer.schedule(new TimerTest(), time * 1000);
	}

	public static void main(String[] args) {
		System.out.println("timer begin...");
		TimerTest01 timerTest01 = new TimerTest01(3);
		System.out.println(timerTest01.timer.getClass());
	}

	class TimerTest extends TimerTask {

		/**
		 * The action to be performed by this timer task.
		 */
		@Override
		public void run() {
			System.out.println("Time's up!!!");
		}
	}

}
