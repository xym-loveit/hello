package com.xym.first;

;

/**
 * ces
 * xym_loveit@126.com
 *
 * @author xym
 * @create 2017-04-01-9:54
 */
public class Student {

	private String name;
	private int age;
	private int sex;

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
}
