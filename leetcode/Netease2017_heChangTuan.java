package leetcode;

import java.util.Scanner;

public class Netease2017_heChangTuan {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();          // n 个学生
            int[] arr = new int [n+1];
            for (int i = 1; i <=n ; i++) {
                arr[i] = cin.nextInt();
            }
            int K = cin.nextInt();            // 选出K个
            int d = cin.nextInt();            // 两个学生的位置编号的差不超过 d
            long[][] fmax = new long[K+1][n+1]; // 记录最大乘积
            long[][] fmin = new long[K+1][n+1]; // 记录最小乘积
            // fmax[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最大乘积；
            // fmin[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最小乘积；
            //初始化第一行
            long  res = Integer.MIN_VALUE; // 记得用Long类型，考虑数值范围
            for (int i = 1; i <=n; i++) {
                fmax[1][i] = arr[i];
                fmin[1][i] = arr[i];
                for (int k = 2; k <=K; k++) {
                    for (int j = i-1 ; j > 0 &&  i-j<=d ; j--) {
                        fmax[k][i] = Math.max(fmax[k][i], Math.max(fmax[k-1][j] * arr[i], fmin[k-1][j] * arr[i]));
                        fmin[k][i] = Math.min(fmin[k][i], Math.min(fmax[k-1][j] * arr[i], fmin[k-1][j] * arr[i]));
                    }
                }
                res = Math.max(res ,fmax[K][i]);
            }
            System.out.println(res);
        }
    }
}
