package com.xym.first;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *safe thread
 *xym_loveit@126.com
 *@author xym
 *@create 2017-04-25-10:25
 */
public class NameList {

	private List nameList = Collections.synchronizedList(new LinkedList());

	public synchronized void add(String name) {
		nameList.add(name);
	}

	public synchronized String removeFirst() {
		if (nameList.size() > 0) {
			return (String) nameList.remove(0);
		} else {
			return null;
		}
	}
}
