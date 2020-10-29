//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表 
// 👍 293 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.Stack;

//Java：两数相加 II
public class P445AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new P445AddTwoNumbersIi().new Solution();
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
        //第2题，从低位开始，所以很好弄，本题是从高位开始，是一个逆序，所以首先想到的应该是栈！！！！！！
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<ListNode> stack1 = new Stack<>();
            Stack<ListNode> stack2 = new Stack<>();
            while (l1 != null) {
                stack1.push(l1);
                l1 = l1.next;
            }
            while (l2 != null) {
                stack2.push(l2);
                l2 = l2.next;
            }
            ListNode res = null;
            int carry = 0;
            while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
                int num1 = stack1.isEmpty() ? 0 : stack1.pop().val;
                int num2 = stack2.isEmpty() ? 0 : stack2.pop().val;
                int sum = num1 + num2 + carry;
                ListNode node = new ListNode(sum % 10);
                carry = sum / 10;
                //这两行很关键
                node.next = res;
                res = node;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}