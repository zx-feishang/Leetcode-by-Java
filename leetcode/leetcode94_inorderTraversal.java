
package leetcode;

/*94. 二叉树的中序遍历

        给定一个二叉树，返回它的中序 遍历。

        示例:

        输入: [1,null,2,3]
        1
         \
          2
        /
        3

        输出: [1,3,2]
        进阶: 递归算法很简单，你可以通过迭代算法完成吗？*/

import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class leetcode94_inorderTraversal {
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
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
        list = inorderTraversal(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }


    }
}



