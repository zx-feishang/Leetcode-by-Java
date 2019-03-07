package leetcode;


/*给定一个二叉树，返回它的 后序 遍历。

        示例:

        输入: [1,null,2,3]
        1
          \
          2
        /
        3

        输出: [3,2,1]
        进阶: 递归算法很简单，你可以通过迭代算法完成吗？*/

import java.util.*;

public class leetcode145_postorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.push(node.left);//和传统先序遍历不一样，先将左结点入栈
            if (node.right != null) stack.push(node.right);//后将右结点入栈
            res.add(0, node.val);                        //逆序添加结点值
        }
        return res;
    }

    public static List<Integer> postorderTraversal1(TreeNode root) {//非递归写法
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if ((curr.left == null && curr.right == null) ||
                    (pre != null && (pre == curr.left || pre == curr.right))) {
                //如果当前结点左右子节点为空或上一个访问的结点为当前结点的子节点时，当前结点出栈
                res.add(curr.val);
                pre = curr;
                stack.pop();
            } else {
                if (curr.right != null) stack.push(curr.right); //先将右结点压栈
                if (curr.left != null) stack.push(curr.left);   //再将左结点入栈
            }
        }
        return res;
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
        list = postorderTraversal(root);

        List<Integer> list1 = postorderTraversal1(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      }
