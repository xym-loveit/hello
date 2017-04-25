package com.xym;

;

/**
 * desc
 *
 * @author xym
 * @create 2017-04-25 23:10
 */
public class SaveThread extends Thread {

    private String name;
    private int cash;
    private MyCount count;

    public SaveThread(String name, int cash, MyCount count) {
        this.name = name;
        this.cash = cash;
        this.count = count;
    }

    public void run() {
        count.save(cash, name);
    }
}