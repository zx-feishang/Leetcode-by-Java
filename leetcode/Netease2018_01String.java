package leetcode;

/*如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。
        例如: "1","10101","0101010"都是交错01串。小易现在有一个01串s,
        小易想找出一个最长的连续子串,并且这个子串是一个交错01串。
        小易需要你帮帮忙求出最长的这样的子串的长度是多少。*/

import java.util.Scanner;

public class Netease2018_01String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        char[] chs = s.toCharArray();
        int count = 1;
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (chs[i] != chs[i - 1]) {
                ++count;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
