//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针 
// 👍 357 👎 0


package leetcode.editor.cn.round6;

import leetcode.editor.cn.ListNode;

//Java：旋转链表
public class P61RotateList {
    public static void main(String[] args) {
        Solution solution = new P61RotateList().new Solution();
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
        public ListNode rotateRight(ListNode head, int k) {
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
            if (head == null || k < 0) {
                return head;
            }
            ListNode cur = head;
            //记录node节点个数
            int count = 1;
            while (cur.next != null) {
                count++;
                cur = cur.next;
            }
            //cur指向了尾部
            k = k % count;
            //成环,找到断开环的位置就可以了
            cur.next = head;

            ListNode node = head;
            for (int i = 0; i < count - k - 1; i++) {
                node = node.next;
            }
            ListNode newHead = node.next;
            //断开
            node.next = null;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}