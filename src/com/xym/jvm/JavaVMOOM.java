package com.xym.jvm;


/**
 * VM Args:-Xss128k
 * 栈内存溢出
 *
 * @author xym
 * @create 2017-05-05 23:59
 */
public class JavaVMOOM {

    private void dontStop() {
        while (true) {

        }
    }

    private void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        new JavaVMOOM().stackLeakByThread();
    }

}