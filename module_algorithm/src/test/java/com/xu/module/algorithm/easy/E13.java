package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;
import com.xu.module.algorithm.proxy.JavaProxy;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 言吾許
 */
public class E13 {
    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 输入：LVIII 输出：58
     * 输入：MCMXCIV 输出：1994
     */

    @Test
    public void test() {
        PrintUtil.print(getInt("MCMXCIV"));
    }

    private int getInt(String s) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        for (int i = 0; i < s.length(); ) {

        }

        return result;
    }
}
