package leetcode;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*小易将n个棋子摆放在一张无限大的棋盘上。第i个棋子放在第x[i]行y[i]列。
同一个格子允许放置多个棋子。每一次操作小易可以把一个棋子拿起并将其移动到原格子的上、下、左、右的任意一个格子中。
小易想知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋子所需要的最少操作次数.*/
public class Netease2018_duiGeZi {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] x = bf.readLine().split(" ");
        String[] y = bf.readLine().split(" ");
        int[] x_arr = trans(x);
        int[] y_arr = trans(y);
        int[] distance = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    distance[k] = Math.abs(x_arr[k] - x_arr[i]) + Math.abs(y_arr[k] - y_arr[j]);
                }
                Arrays.sort(distance);
                int temp = 0;
                for (int r = 0; r < n; r++) {
                    temp += distance[r];
                    res[r] = Math.min(temp, res[r]);
                }
            }
        }
        for (int i = 0; i < n - 1; i++)
            System.out.print(res[i] + " ");
        System.out.print(res[n - 1]);
    }

    public static int[] trans(String[] a) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = Integer.parseInt(a[i]);
        }
        return res;
    }
}
