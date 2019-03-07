package leetcode;

import java.util.Scanner;

public class Netease2018_dependentXiaoYi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int f = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(getLiveDays(x, f, d, p));
    }

    private static int getLiveDays(int x, int f, int d, int p) {
        int res = 0;
        if (d / x < f) {
            res = d / x;
        } else {
            res = f + (d - f * x) / (p + x);
        }
        return res;
    }
}
