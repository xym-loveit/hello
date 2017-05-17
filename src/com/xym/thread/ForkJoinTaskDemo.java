package com.xym.thread;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *统计目录下的文件（效率杠杠的）
 *
 *@author xym
 *@create 2017-05-16-20:50
 */
public class ForkJoinTaskDemo {
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Integer count = forkJoinPool.invoke(new CountingTask(Paths.get("e:/")));
		System.out.println("D 盘下文件数量为： " + count);
		showLog(forkJoinPool);
		System.out.println("The Main Thread End!");
	}

	/**
	 * fork/join 监控信息
	 * @param forkJoinPool
	 */
	private static void showLog(ForkJoinPool forkJoinPool) {
		System.out.println("***********************************************\n");
		System.out.println("Fork/Join Pool: （并行级别）getParallelism=" + forkJoinPool.getParallelism());
		System.out.println("Fork/Join Pool: （worker线程数量）getPoolSize=" + forkJoinPool.getPoolSize());
		System.out.println("Fork/Join Pool: （当前执行任务的线程数量）getActiveThreadCount=" + forkJoinPool
				.getActiveThreadCount());
		System.out.println("Fork/Join Pool: （正在工作的线程）getRunningThreadCount=" + forkJoinPool
				.getRunningThreadCount());

		System.out.println("Fork/Join Pool: （提交给池但还未执行的任务数）getQueuedSubmissionCount=" + forkJoinPool
				.getQueuedSubmissionCount());
		System.out.println("Fork/Join Pool: （提交给池并开始执行的任务数）getQueuedTaskCount=" + forkJoinPool
				.getQueuedTaskCount());

		System.out.println("Fork/Join Pool:（池中是否还有排队的任务未执行） hasQueuedSubmissions=" + forkJoinPool
				.hasQueuedSubmissions());
		System.out.println(
				"Fork/Join Pool: （fork/join池是否已经完成执行）isTerminated=" + forkJoinPool.isTerminated());
		System.out.println("\n***********************************************");
	}
}

class CountingTask extends RecursiveTask<Integer> {

	private Path dir;

	public CountingTask(Path dir) {
		this.dir = dir;
	}

	protected Integer compute() {
		int count = 0;

		List<CountingTask> countingTasks = new ArrayList<CountingTask>();

		try {
			DirectoryStream<Path> paths = Files.newDirectoryStream(dir);
			for (Path path : paths) {
				if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
					//对每个目录新建一个子任务
					countingTasks.add(new CountingTask(path));
				} else {
					count++;
				}
			}

			if (!countingTasks.isEmpty()) {
				//在当前的forkjoinpool上调度所有子任务
				for (CountingTask task : invokeAll(countingTasks)) {
					count += task.join();
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}
}
