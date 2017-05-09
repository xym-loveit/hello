package com.xym.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *通过实例演示jconsole监控jvm内存状态
 *
 *@author xym
 *@create 2017-05-09-22:24
 */
public class MonitoringTest {

	private static class OOMObject {
		public byte[] placeholder = new byte[64 * 1024];
	}

	public static void main(String[] args) throws InterruptedException {
		fillHeap(1000);
	}

	public static void fillHeap(int count) throws InterruptedException {
		List<OOMObject> list = new ArrayList<OOMObject>();
		for (int i = 0; i < count; i++) {
			Thread.sleep(50);//增加延时,使监视曲线更加明显
			list.add(new OOMObject());
		}

		System.gc();
	}

}
