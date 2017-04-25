package com.xym;

;import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * desc
 *
 * @author xym
 * @create 2017-04-25 23:13
 */
public class TestSaveAndCash {

    public static void main(String[] args) {

        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //创建并发访问账户
        MyCount count = new MyCount("62171800102434987", 1000);

        SaveThread save1 = new SaveThread("张三", 2000, count);
        SaveThread save2 = new SaveThread("张一山", 1500, count);
        DrawThread draw1 = new DrawThread(count, 2200, "张三妈妈");
        DrawThread draw2 = new DrawThread(count, 100, "张一山老婆");
        SaveThread save3 = new SaveThread("张2三", 2000, count);
        //执行各个线程
        executorService.execute(save1);
        executorService.execute(save2);
        executorService.execute(draw1);
        executorService.execute(draw2);
        executorService.execute(save3);

        //关闭线程池
        executorService.shutdown();

    }

}