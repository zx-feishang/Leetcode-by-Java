package leetcode;

//小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
//你能帮帮小Q吗？

import java.util.Scanner;

public class tencent2017_movingCapitals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] chars = scanner.nextLine().toCharArray();
            int length = chars.length;
            for (int i = 0; i < length; i++) {
                for (int j = 1; j < length - i; j++) {
                    if ((chars[j - 1] >= 'A' && chars[j - 1] <= 'Z') &&
                            (chars[j] < 'A' || chars[j] > 'Z')) {
                        char temp = chars[j - 1];
                        chars[j - 1] = chars[j];
                        chars[j] = temp;
                    }
                }
            }
            System.out.println(String.valueOf(chars));
        }
    }
}

