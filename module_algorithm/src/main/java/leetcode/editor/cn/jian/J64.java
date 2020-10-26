package leetcode.editor.cn.jian;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

public class J64 {
    public static void main(String[] args) {
        J64.Solution solution = new J64().new Solution();
        // TO TEST
        solution.sumnums(55);
    }

    class Solution {
        private int res = 0;

        private int sumnums(int n) {
            boolean flag = n > 1 && sumnums(n - 1) > 0;
            res += n;
            return res;
        }
    }
}
