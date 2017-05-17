package com.xym.thread;

import java.util.concurrent.*;

/**
 *线程池监控，之定义实现ThreadPoolExecutor
 *
 *@author xym
 *@create 2017-05-17-9:49
 */
public class MonitorThreadPoolExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(500);

		ExecutorService poolExecutor = new MonitorThreadPoolExecutor(5, 5, 0L,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						Thread.sleep(500L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};

			poolExecutor.execute(runnable);
		}

		poolExecutor.shutdown();

		System.out.println("Thread Main End!");
	}

}

class MonitorThreadPoolExecutor extends ThreadPoolExecutor {

	public MonitorThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
			TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	protected void beforeExecute(Thread t, Runnable r) {
		System.out.println("work task before " + t.getName() + "--" + t);
	}

	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		System.out.println("work task after " + r);
	}

	protected void terminated() {
		System.out.println("terminated :\ngetCorePoolSize=" + getCorePoolSize());
		System.out.println("getPoolSize=" + getPoolSize());
		System.out.println("getTaskCount=" + getTaskCount());
		System.out.println("getCompletedTaskCount=" + getCompletedTaskCount());
		System.out.println("getLargestPoolSize=" + getLargestPoolSize());
		System.out.println("getActiveCount=" + getActiveCount());
		System.out.println("getMaximumPoolSize=" + getMaximumPoolSize());
	}
}
