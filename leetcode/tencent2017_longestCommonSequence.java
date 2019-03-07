package leetcode;

//给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
//输出需要删除的字符个数。

import java.util.Scanner;

public class tencent2017_longestCommonSequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            StringBuffer sb = new StringBuffer(s);
            String sb1 = sb.reverse().toString();
            System.out.println(sb.length() - longestCommonSubsquence(s, sb1));
        }
    }

    private static int longestCommonSubsquence(String sb, String sb1) {
        int[][] dp = new int[sb.length() + 1][sb1.length() + 1];
        for (int p = 1; p <= sb.length(); p++) {
            for (int q = 1; q <= sb1.length(); q++) {
                int temp = Math.max(dp[p - 1][q], dp[p][q - 1]);
                if (sb.charAt(p - 1) - sb1.charAt(q - 1) == 0) {
                    temp = dp[p - 1][q - 1] + 1;
                }
                dp[p][q] = temp;
            }
        }
        for (int k = 0; k <= sb.length(); k++) {
            for (int j = 0; j <= sb1.length(); j++) {
                System.out.print(dp[k][j] + " ");
            }
            System.out.println();
        }


        return dp[sb.length()][sb1.length()];
    }
}
