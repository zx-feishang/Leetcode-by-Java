package leetcode;

import java.util.Scanner;

public class Netease2019_characterPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int count = 0;
            char[][] chars = new char[row][col];
            for (int j = 0; j < row; j++) {
                chars[j] = sc.next().toCharArray();
            }
            String target = sc.next();
            for (int m = 0; m < row; m++) {
                for (int n = 0; n < col; n++) {
                    if (isVaild1(chars, row, col, m, n, target)) {
                        count++;
                    }
                    if (isVaild2(chars, row, col, m, n, target)) {
                        count++;
                    }
                    if (isVaild3(chars, row, col, m, n, target)) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isVaild1(char[][] chars, int row, int col, int m, int n, String s) {
        if (n + s.length() <= col) {
            int i = 0;
            while (i < s.length() && s.charAt(i) == chars[m][n + i]) {
                i++;
            }
            if (i == s.length()) return true;
        }

        return false;

    }

    private static boolean isVaild2(char[][] chars, int row, int col, int m, int n, String s) {
        if (m + s.length() <= row) {
            int i = 0;
            while (i < s.length() && s.charAt(i) == chars[m + i][n]) {
                i++;
            }
            if (i == s.length()) return true;
        }

        return false;

    }

    private static boolean isVaild3(char[][] chars, int row, int col, int m, int n, String s) {
        if (m + s.length() <= row && n + s.length() <= col) {
            int i = 0;
            while (i < s.length() && s.charAt(i) == chars[m + i][n + i]) {
                i++;
            }
            if (i == s.length()) return true;
        }

        return false;

    }

}

