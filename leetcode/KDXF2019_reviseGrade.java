package leetcode;

import java.util.Scanner;

public class KDXF2019_reviseGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int X = sc.nextInt();
            int[] grades = new int[n];
            for(int j = 0; j < n; j++){
                grades[j] = sc.nextInt();
            }
            System.out.println(reviseNum(grades,n,X));
        }
    }

    private static int reviseNum(int[] grades, int n, int x) {
        int count = 0;
        while(getAverage(grades,n)<x){
            count++;
            int index =  getMin(grades);
            grades[index] = 100;
        }
        return count;
    }

    private static int getMin(int[] grades) {
        int index = 0;
        for(int i = 0; i < grades.length; i++){
            if(grades[index] > grades[i])
                index = i;
        }
        return index;
    }

    private static int getAverage(int[]  grades, int n) {
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += grades[i];
        }
        return sum / n;
    }
}