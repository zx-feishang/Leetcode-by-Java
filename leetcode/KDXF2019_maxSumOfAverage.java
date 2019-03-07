package leetcode;

import java.util.*;

public class KDXF2019_maxSumOfAverage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int len1 = sc.nextInt();
        int len2 = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        int[] res = new int[arr.length];

        if (len1 >= len2) {
            Arrays.fill(res, 2);
            for (int m = 1; m <= 5; m++) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == m) {
                        list.add(i);
                    }
                }
            }
            for (int i = 0; i < len1; i++) {
                res[list.get(i)] = 1;
            }

        } else {
            Arrays.fill(res, 2);
            for (int m = 1; m <= 5; m++) {
                for (int i = arr.length - 1; i >= 0; i--) {
                    if (arr[i] == m) {
                        list1.add(i);
                    }
                }
            }
            for (int i = arr.length - 1; i >= len1; i--) {
                res[list.get(i)] = 1;
            }

        }


        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}

