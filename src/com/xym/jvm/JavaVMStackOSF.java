package com.xym.jvm;

;

/**
 * VM Args:-Xss128k
 * 栈内存溢出
 *
 * @author xym
 * @create 2017-05-05 23:50
 */
public class JavaVMStackOSF {

    private int stackLength = 1;

    public static void main(String[] args) {
        JavaVMStackOSF javaVMStackOSF = new JavaVMStackOSF();
        try {
            javaVMStackOSF.stackLeak();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("stackLength=" + javaVMStackOSF.stackLength);
        }
    }

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

}