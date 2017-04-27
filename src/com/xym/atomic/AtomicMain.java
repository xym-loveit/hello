package com.xym.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-27-16:40
 */
public class AtomicMain {

	public static void main(String[] args) {
		/*AtomicIntegerArray array = new AtomicIntegerArray(new int[] { 1, 2, 3, 4 });

		array.addAndGet(1, 5);

		System.out.println(array.toString());

		System.out.println(array.get(1));
		System.out.println(array.compareAndSet(1, 7, 44));
		System.out.println(array.get(1));*/

		AtomicReference<Users> reference = new AtomicReference<Users>();
		Users admin = new Users("admin", "123456");
		Users zhangsan = new Users("zhangsan", "123456");

		reference.set(admin);
		System.out.println(reference.toString());
		reference.compareAndSet(admin, zhangsan);
		System.out.println(reference.toString());



	}
}
