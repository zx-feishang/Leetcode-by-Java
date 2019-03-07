package leetcode;

import java.util.Scanner;

public class Netease2019_timeClock {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            String[] s = sc.next().split(":");
            int[] arr = new int[s.length];
            for (int j = 0; j < s.length; j++) {
                arr[j] = Integer.parseInt(s[j]);
            }
            StringBuffer sb = new StringBuffer();
            arr[0] = arr[0] / 10 > 2 ? arr[0] % 10 : arr[0];
            arr[0] = arr[0] / 10 == 2 && arr[0] % 10 > 3 ? arr[0] % 10 : arr[0];

            arr[1] = arr[1] > 59 ? arr[1] % 10 : arr[1];
            arr[2] = arr[2] > 59 ? arr[2] % 10 : arr[2];
            for (int k = 0; k <= 1; k++) {
                if (arr[k] < 10) {
                    sb.append("0");
                    sb.append(arr[k]);
                    sb.append(":");
                } else {
                    sb.append(arr[k]);
                    sb.append(":");
                }
            }

            if (arr[2] < 10) {
                sb.append("0");
                sb.append(arr[2]);
            } else {
                sb.append(arr[2]);
            }

            System.out.println(sb.toString());

        }
    }
}
