package leetcode;

/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。*/

import java.util.Stack;

public class leetcode20_isValid {

    public static boolean isValid(String s) {
        if (s == null) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else return false;
            } else if (s.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else return false;
            } else if (s.charAt(i) == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else return false;
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}
