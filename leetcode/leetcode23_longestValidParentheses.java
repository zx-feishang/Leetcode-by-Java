package leetcode;

import java.util.Stack;
/*给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

        示例 1:

        输入: "(()"
        输出: 2
        解释: 最长有效括号子串为 "()"
        示例 2:

        输入: ")()())"
        输出: 4
        解释: 最长有效括号子串为 "()()"*/

public class leetcode23_longestValidParentheses {
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int max = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i != s.length(); ++i){
            if (s.charAt(i) == '('){
                stack.push(i);
            }
            if (s.charAt(i) == ')'){
                stack.pop();
                if (stack.isEmpty())
                    stack.push(i);
                else
                    max = max > i - stack.peek()?max:i - stack.peek();
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(longestValidParentheses(s));

    }
}
