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
		Integer count = new ForkJoinPool().invoke(new CountingTask(Paths.get("c:/")));
		System.out.println("D 盘下文件数量为： " + count);
		System.out.println("The Main Thread End!");
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
