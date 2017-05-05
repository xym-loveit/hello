package com.xym.jvm;

import java.util.ArrayList;
import java.util.List;

;

/**
 * VM Args: -XX:PermSize=10m -XX:MaxPermSize=10m
 * 常量池内存溢出
 *
 * @author xym
 * @create 2017-05-06 0:06
 */
public class RunntimeConstantPoolOOM {
    public static void main(String[] args) {
        //使用list保证常量池引用，避免gc回收
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}