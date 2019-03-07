/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 * 50.实现 pow(x, n) ，即计算 x 的 n 次幂函数
 * @author Shine
 */
public class leetcode50_MyPow {

    public static double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else if (n > 0) {
            return half * half * x;
        } else {
            return half * half / x;
        }

    }

    public static void main(String[] args) {
        System.out.println(myPow(0.00001, 2147483647));
    }

}
