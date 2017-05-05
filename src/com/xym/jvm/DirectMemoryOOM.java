package com.xym.jvm;

;import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * 直接内存溢出
 *
 * @author xym
 * @create 2017-05-06 0:39
 */
public class DirectMemoryOOM {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        try {
            Unsafe o = (Unsafe) field.get(null);
            while (true) {
                o.allocateMemory(_1M);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

}