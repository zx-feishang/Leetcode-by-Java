package leetcode;

// 二叉树前序遍历
/*给定一个二叉树，返回它的 前序 遍历。

        示例:

        输入: [1,null,2,3]
        1
         \
         2
        /
        3

        输出: [1,2,3]
        进阶: 递归算法很简单，你可以通过迭代算法完成吗？*/

import java.util.*;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}

public class leetcode144_preorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

        }
        return list;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.left = node4;
        List<Integer> list = new ArrayList<>();
        list = preorderTraversal(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }
}
