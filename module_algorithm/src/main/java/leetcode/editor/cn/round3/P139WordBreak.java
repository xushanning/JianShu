//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划


package leetcode.editor.cn.round3;

import java.util.ArrayList;
import java.util.List;

//Java：单词拆分
public class P139WordBreak {
    public static void main(String[] args) {
        Solution solution = new P139WordBreak().new Solution();
        // TO TEST
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
        solution.wordBreak("aaaaaaa", list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int len = s.length();
            if (len == 0) {
                return false;
            }
            //动态规划  dp[i]为s的前i个字符串是否能被拆成list中的字符，
            boolean[] dp = new boolean[len + 1];
            dp[0] = true;
            for (int i = 1; i <= len; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    dp[i] = dp[j] && wordDict.contains(s.substring(j, i));
                    //只要一次能组成就跳出本次，往前走
                    if (dp[i]) {
                        break;
                    }
                }
            }
            return dp[len];


            //双指针  测试用例败在了  "aaaaaaa"  ["aaaa","aaa"] 上，大爷的
//            int left = 0;
//            int right = 1;
            //s = "leetcode", wordDict = ["leet", "code"]

//            while (true) {
//                String item = s.substring(left, right);
//                if (right == len) {
//                    return wordDict.contains(item);
//                } else {
//                    if (wordDict.contains(item)) {
//                        left = right;
//                    }
//                    right++;
//                }
//            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}