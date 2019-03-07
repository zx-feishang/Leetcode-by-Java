package leetcode;

//有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型
import java.util.*;

public class PDD2018_bigIntegerMultiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        String str1 = strs[0];
        String str2 = strs[1];
        int len1 = str1.length();
        int len2 = str2.length();
        int[] num = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int index = len1 + len2 - 1 - (len1 - 1 - i) - (len2 - 1 - j);
                num[index] += (str1.charAt(i) - '0') * (str2.charAt(j) - '0');
            }
        }
        int jinwei = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int temp = num[i] + jinwei;
            num[i] = temp % 10;
            jinwei = temp / 10;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0) {
                index = i;
                break;
            }
        }
        for (int i = index; i < num.length; i++) {
            sb.append(num[i]);
        }
        System.out.println(sb.toString());
    }
}
