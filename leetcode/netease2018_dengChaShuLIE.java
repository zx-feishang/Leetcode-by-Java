package leetcode;

import java.util.Scanner;
import java.util.Arrays;
public class netease2018_dengChaShuLIE {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int []arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(isValid(arr));

    }
    private static boolean isValid(int[] arr){
        int diff = arr[1]-arr[0];
        for(int i=1;i< arr.length;i++){
            if(arr[i]-arr[i-1]!=diff){
                return false;
            }
        }
        return true;
    }
}

