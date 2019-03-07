package leetcode;

/*小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
        1、将a_i放入b序列的末尾
        2、逆置b序列
        小易需要你计算输出操作n次之后的b序列。*/

import java.util.Scanner;
import java.util.Stack;

public class Netease2018_oprateSeq {
   /* public static void main(String[] args) {
        //long start = System.currentTimeMillis();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {
            //System.out.println(arr[i]);
            stack.push(sc.nextInt());
            while (!stack.isEmpty()) {
                stack1.push(stack.pop());
            }
            Stack<Integer> temp = stack;
            stack = stack1;
            stack1 = temp;
        }
        stack.push(sc.nextInt());
        for (int i = 0; i < n - 1; i++) {
            System.out.print(stack.pop() + " ");
        }
        System.out.print(stack.pop());
        //long end = System.currentTimeMillis(); //获取结束时间
        //System.out.println("程序运行时间： " + (end - start) + "ms");
    }*/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            for (int i = n - 1; i >= 0; i -= 2) {     // 前一半从最后一个数开始以2为步长递减
                System.out.print(nums[i] + " ");
            }
            for (int i = n % 2; i < n - 2; i += 2) {  // 后一半根据整数个数的奇偶，分别从第二个或第一个数开始以2为步长递增
                System.out.print(nums[i] + " ");
            }
            System.out.print(nums[n - 2]);  // 最后一个数
        }
    }

}
