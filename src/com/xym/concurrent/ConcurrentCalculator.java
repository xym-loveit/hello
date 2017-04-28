package com.xym.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *并行计算数组的和,例子短小精悍，分而治之
 *
 *@author xym
 *@create 2017-04-28-10:13
 */
public class ConcurrentCalculator {

	private ExecutorService exec;//线程池对象
	private int cpuCoreNumber;//cpu 核数
	private List<Future<Long>> tasks = new ArrayList<Future<Long>>();//任务执行结果集合

	// 内部类
	class SumCalculator implements Callable<Long> {
		private int[] numbers;
		private int start;
		private int end;

		public SumCalculator(final int[] numbers, int start, int end) {
			this.numbers = numbers;
			this.start = start;
			this.end = end;
		}

		public Long call() throws Exception {
			Long sum = 0l;
			for (int i = start; i < end; i++) {
				sum += numbers[i];
			}
			return sum;
		}
	}

	public ConcurrentCalculator() {
		cpuCoreNumber = Runtime.getRuntime().availableProcessors();
		System.out.println("availableProcessors=" + cpuCoreNumber);
		exec = Executors.newFixedThreadPool(cpuCoreNumber);
	}

	public Long sum(final int[] numbers) {
		// 根据CPU核心个数拆分任务，创建FutureTask并提交到Executor
		for (int i = 0; i < cpuCoreNumber; i++) {
			int increment = numbers.length / cpuCoreNumber + 1;
			//System.out.println("increment=" + increment);
			int start = increment * i;
			//
			if (start >= numbers.length) {
				start = numbers.length;
			}

			int end = increment * i + increment;
			if (end > numbers.length) {
				end = numbers.length;
			}
			if (start < end && start != end) {
				System.out.println("start=" + start + ",end=" + end);
				SumCalculator subCalc = new SumCalculator(numbers, start, end);
				FutureTask<Long> task = new FutureTask<Long>(subCalc);
				tasks.add(task);
				if (!exec.isShutdown()) {
					exec.submit(task);
				}
			} else {
				break;
			}
		}
		return getResult();
	}

	/**
	 * 迭代每个只任务，获得部分和，相加返回
	 *
	 * @return
	 */
	public Long getResult() {
		Long result = 0l;
		System.out.println("getResult tasks=" + tasks.size());
		for (Future<Long> task : tasks) {
			try {
				// 如果计算未完成则阻塞
				Long subSum = task.get();
				result += subSum;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public void close() {
		exec.shutdown();
	}

	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12 };
		ConcurrentCalculator calc = new ConcurrentCalculator();
		Long sum = calc.sum(numbers);
		System.out.println(sum);
		calc.close();
	}
}
