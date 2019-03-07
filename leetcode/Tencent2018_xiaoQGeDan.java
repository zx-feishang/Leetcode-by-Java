package leetcode;

/*
【题目描述】小 Q 有 X 首长度为 A 的不同的歌和 Y 首长度为 B 的不同的歌，现在小 Q 想用这些歌组成一个
        总长度正好为 K 的歌单，每首歌最多只能在歌单中出现一次，在不考虑歌单内歌曲的先后顺序的情况下，
        请问有多少种组成歌单的方法。
        输入描述：
        每个输入包含一个测试用例。
        每个测试用例的第一行包含一个整数，表示歌单的总长度 K(1<=K<=1000)。
        接下来的一行包含四个正整数，分别表示歌的第一种长度 A(A<=10)和数量 X(X<=100)以及歌的第二种长度
        B(B<=10)和数量 Y(Y<=100)。保证 A 不等于 B。
        输出描述：
        输出一个整数,表示组成歌单的方法取模。因为答案可能会很大,输出对 1000000007 取模的结果。
        输入示例：
        5
        2 3 3 3
        输出示例：
        9
*/


import java.util.Scanner;
import java.util.Arrays;

public class Tencent2018_xiaoQGeDan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int A = sc.nextInt();
        int X = sc.nextInt();
        int B = sc.nextInt();
        int Y = sc.nextInt();
        System.out.println(getGroupNumByDP(K, A, X, B, Y));
        System.out.println(getGroupNum(K, A, X, B, Y));

    }

    private static int getGroupNumByDP(int K, int A, int X, int B, int Y) {
        // 动态规划解法   背包问题的改变   将每首歌的长度看做price
        // K当做背包容量
        int[] price = new int[X + Y + 1];
        Arrays.fill(price, 1, X + 1, A);
        Arrays.fill(price, X + 1, X + Y + 1, B);


        int[][] dp = new int[X + Y + 1][K + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= X + Y; i++) {
            for (int j = 0; j <= K; j++) {
                if (j >= price[i]) {
                    dp[i][j] = dp[i - 1][j] % 1000000007 + dp[i - 1][j - price[i]] % 1000000007;
                } else {
                    dp[i][j] = dp[i - 1][j] % 1000000007;
                }

            }
        }
/*        for (int[] t1 : dp) {
            for (int t2 : t1) {
                System.out.print(t2 + " ");
            }
            System.out.println();
        }*/
        return dp[X + Y][K] % 1000000007;
    }


    private static int getGroupNum(int K, int A, int X, int B, int Y) {
        int sum = 0;
        int[][] combine = CombineGroupNum(X, X);
        for (int i = 1; i <= X; i++) {
            if (i * A <= K && (K - i * A) % B == 0 && (K - i * A) / B <= Y) {
                // 所有可能组合方式累加求和
                sum += (combine[X][i] * combine[Y][(K - i * A) / B]) % 1000000007;
            }
        }

        return sum;
    }

    private static int[][] CombineGroupNum(int m, int n) {
        // 求解组合数C(m,n) = C(n-1,m-1)+C(n-1,m)  (杨辉三角）
        int[][] res = new int[m + 1][n + 1];
        res[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            res[i][0] = 1;
            for (int j = 1; j <= n; j++) {
                res[i][j] = (res[i - 1][j - 1] + res[i - 1][j]);
            }
        }
        return res;
    }
}



