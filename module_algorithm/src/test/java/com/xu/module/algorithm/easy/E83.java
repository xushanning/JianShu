package com.xu.module.algorithm.easy;

import com.xu.module.algorithm.PrintUtil;

import org.junit.Test;

/**
 * @author 许 on 2019/12/24.
 * 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class E83 {
    @Test
    public void test() {
        ListNode data5 = new ListNode(3);
        ListNode data4 = new ListNode(3);
        ListNode data3 = new ListNode(2);
        ListNode data2 = new ListNode(1);
        ListNode data1 = new ListNode(1);
        data1.next = data2;
        data2.next = data3;
        data3.next = data4;
        data4.next = data5;
        data5.next = null;

        ListNode listNode = deleteDuplicates(data1);
        while (listNode != null) {
            PrintUtil.print(listNode.val);
            listNode = listNode.next;
        }
    }

    private ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = head;
        while (listNode.next != null) {
            if (listNode.val == listNode.next.val) {
                listNode.next = listNode.next.next;
            } else {
                listNode = listNode.next;
            }
        }
        return head;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
}
