//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：回文链表
public class P234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            List<Integer> vals = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                vals.add(cur.val);
                cur = cur.next;
            }
            int left = 0;
            int right = vals.size() - 1;
            while (left < right) {
                if (!vals.get(left).equals(vals.get(right))) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}