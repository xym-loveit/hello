package com.xym;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 普通银行账户不可透支
 *
 * @author xym
 * @create 2017-04-25 22:54
 */
public class MyCount {

    private String oid;//账户
    private int cash;//账户余额
    private Lock lock = new ReentrantLock();//账户锁
    private Condition save_cond = lock.newCondition();//存款条件
    private Condition draw_cond = lock.newCondition();//取款条件

    public MyCount(String oid, int cash) {
        this.oid = oid;
        this.cash = cash;
    }


    /**
     * @param cash
     * @param name
     */
    public void save(int cash, String name) {
        lock.lock();
        if (cash > 0) {
            this.cash += cash;
            System.out.println(name + " 存款 " + cash + ",账户余额 " + this.cash);
        }
        draw_cond.signalAll();
        lock.unlock();
    }


    /**
     * @param x
     * @param name
     */
    public void drawing(int x, String name) {

        lock.lock();//获取锁

        try {
            if (cash - x < 0) {
                draw_cond.await();  //  阻塞取款操作
            } else {
                cash -= x;
                System.out.println(name + " 取款 " + x + ",账户余额 " + this.cash);
            }
            save_cond.signalAll();  //  唤醒所有存款的操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//释放锁
        }

    }
}