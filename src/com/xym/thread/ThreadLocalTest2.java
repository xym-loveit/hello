package com.xym.thread;

import java.util.HashMap;
import java.util.Map;

/**
 *desc
 *
 *@author xym
 *@create 2017-05-16-16:46
 */
public class ThreadLocalTest2 {

	private static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

	public static String getSid() {
		Map map = (Map) threadLocal.get();
		if (map != null) {
			return (String) map.get("sid");
		}
		return null;
	}

	public static void setSid(String sid) {
		Map map = (Map) threadLocal.get();
		if (map == null) {
			map = new HashMap();
		}
		map.put("sid", sid);
		threadLocal.set(map);
	}

	public static String getOrg() {
		Map map = (Map) threadLocal.get();
		if (map != null) {
			return (String) map.get("orgName");
		}
		return null;
	}

	public static void setOrg(String orgName) {
		Map map = (Map) threadLocal.get();
		if (map == null) {
			map = new HashMap();
		}
		map.put("orgName", orgName);
		threadLocal.set(map);
	}

	public static void main(String[] args) {

		TestClient testClient1 = new TestClient();
		TestClient testClient2 = new TestClient();
		TestClient testClient3 = new TestClient();

		testClient1.start();
		testClient2.start();
		testClient3.start();

	}

	private static class TestClient extends Thread {

		public void run() {
			for (int i = 0; i < 3; i++) {
				ThreadLocalTest2.setSid(Thread.currentThread().getName() + i);
				ThreadLocalTest2.setOrg(Thread.currentThread().getName() + i + i);
				System.out.println(
						Thread.currentThread().getName() + "----" + ThreadLocalTest2.getSid()
								+ "----" + ThreadLocalTest2.getOrg());
			}
		}
	}
}
