package leetcode;

import java.util.*;

public class Netease2019_huaHuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(getNum(r, g, b));
    }

    private static int getNum(int r, int g, int b) {
        if (r == 0 || g == 0 || b == 0) {
            // 一种为空
            return r / 3 + g / 3 + b / 3;
        } else {
            int count = 0;
            count = r / 3 + g / 3 + b / 3;
            r %= 3;
            g %= 3;
            b %= 3;
            if (r >= g) swap(r, g);
            if (r >= b) swap(r, b);
            if (g >= b) swap(g, b);

            // r，g，b递增 对于0 2 2 可以加舍弃一个3色，换来2个111 整体count+1
            if (r == 0 && g == 2) {
                count += 1;
            } else {
                count += r;
            }
            return count;
        }
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}