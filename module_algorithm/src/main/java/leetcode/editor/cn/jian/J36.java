package leetcode.editor.cn.jian;


import leetcode.editor.cn.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 */
public class J36 {
    TreeNode head, pre;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }


}
