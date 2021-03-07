package com.xu.module.algorithm;

import java.io.PrintStream;

/**
 * @author 许 on 2020/12/20.
 */

class FileTest {
    public static void main(String[] args) {
        PrintStream ps;
        try {
            System.out.println("1");
            ps = new PrintStream("D:\\Backup\\桌面\\my.txt");
            System.out.println(200);
            for (int i = 0; i < 2; i++) {
                ps.print(3333);
                ps.print("\\n");
            }
            ps.close();
            System.out.println(3);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
