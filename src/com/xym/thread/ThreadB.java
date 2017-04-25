package com.xym.thread;

/**
 *desc
 *
 *@author xym
 *@create 2017-04-25-15:23
 */
public class ThreadB extends Thread {
	int total;

	public void run() {
		synchronized (this) {
			for (int i = 0; i < 101; i++) {
				total += i;
			}
			//（完成计算了）唤醒在此对象监视器上等待的单个线程，在本例中线程A被唤醒
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//（完成计算了）唤醒在此对象监视器上等待的单个线程，在本例中线程A被唤醒
			this.notify();
			try {
				System.out.println("notify 调用之后，本线程开始休眠");
				Thread.sleep(2000);

				/**
				 * 千万注意：当在对象上调用wait()方法时，执行该代码的线程立即放弃它在对象上的锁。然而调用notify()时，并不意味着这时线程会放弃其锁。如果线程荣然在完成同步代码，则线程在移出之前不会放弃锁。因此，只要调用notify()并不意味着这时该锁变得可用。
				 */
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
