//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 731 👎 0


package leetcode.editor.cn.round6;

import java.util.HashMap;
import java.util.Map;

import leetcode.editor.cn.TreeNode;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//     3
//   / \
//  9  20
//    /  \
//   15   7
            int len1 = preorder.length;
            int len2 = inorder.length;
            if (len1 == 0 || len1 != len2) {
                return null;
            }

            Map<Integer, Integer> map = new HashMap<>(len2);
            for (int i = 0; i < len2; i++) {
                map.put(inorder[i], i);
            }
            return getTree(map, preorder, 0, len1, 0, len2);
        }

        //inorder数组不用传入，用map代替了

        private TreeNode getTree(Map<Integer, Integer> map, int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
            if (preStart == preEnd) {
                return null;
            }
            //前序的第一个肯定是根节点
            int rootNum = preorder[preStart];
            TreeNode node = new TreeNode(rootNum);
            //通过map找出在中序中的位置
            int rootIndex = map.get(rootNum);
            //中序左字数的数量
            int leftNum = rootIndex - inStart;
            //这里画一棵树就能做出来！~！！！！！
            node.left = getTree(map, preorder, preStart + 1, preStart + leftNum + 1, inStart, rootIndex);
            node.right = getTree(map, preorder, preStart + leftNum + 1, preEnd, rootIndex + 1, inEnd);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}