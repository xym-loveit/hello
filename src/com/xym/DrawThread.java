package com.xym;

/**
 * 取款类
 *
 * @author xym
 * @create 2017-04-25 23:06
 */
public class DrawThread extends Thread {

    private MyCount count;//账户
    private int cash;//金额
    private String name;//取款人

    public DrawThread(MyCount count, int cash, String name) {
        this.count = count;
        this.cash = cash;
        this.name = name;
    }


    @Override
    public void run() {
        count.drawing(cash, name);
    }
}