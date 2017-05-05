package com.xym.process;

import java.io.IOException;
import java.util.Scanner;

/**
 * desc
 *
 * @author xym
 * @create 2017-04-30 17:29
 */
public class ProcessMain {

    public static void main(String[] args) {
        processRuntime();
    }

    private static void processBuild() {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "ipconfig/all");
        try {
            Process start = processBuilder.start();
            Scanner scanner = new Scanner(start.getInputStream(), "GBK");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processRuntime() {
        try {
            String cmd = "cmd " + "/c " + "ipconfig/all";
            Process exec = Runtime.getRuntime().exec(cmd);
            Scanner scanner = new Scanner(exec.getInputStream(), "GBK");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}