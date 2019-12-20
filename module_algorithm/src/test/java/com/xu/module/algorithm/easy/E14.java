package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

public class E14 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     */
    @Test
    public void test() {
        String[] data = new String[]{"alower", "flow", "flight"};
        PrintUtil.print(getPublicPrefix(data));
    }

    private String getPublicPrefix(String[] data) {
        String publicPrefix = "";
        if (data.length == 0) {
            return publicPrefix;
        }
        int j = 1;
        while (true) {
            String currentPublicPrefix = data[0].substring(0, j);
            if (!hasSamePrefix(data, currentPublicPrefix)) {
                break;
            }
            publicPrefix = currentPublicPrefix;
            j++;
        }
        return publicPrefix;
    }

    /**
     * 是否有相同的头
     *
     * @param data
     * @param prefix
     * @return
     */
    private boolean hasSamePrefix(String[] data, String prefix) {
        for (String item : data) {
            if (!item.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}
