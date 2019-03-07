package leetcode;

import java.util.*;

public class Netease2019_talkingList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            HashSet<Integer> hs = new HashSet<>();
            int len = sc.nextInt();
            int[] arr = new int[len];
            int[] arr1 = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = sc.nextInt();
            }
            for (int k = len - 1; k >= 1; k--) {
                if (!hs.contains(arr[k])) {
                    System.out.print(arr[k] + " ");
                    hs.add(arr[k]);
                }
            }
            if (!hs.contains(arr[0])) {
                System.out.print(arr[0]);

            }
            System.out.println();
        }
    }
}
