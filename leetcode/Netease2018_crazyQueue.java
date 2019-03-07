package leetcode;

//小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,
// 并且他要求学生按照身高不递减的顺序排列。有一次,n个学生在列队的时候,小易老师正好去卫生间了。
// 学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。
// 由于按照身高顺序排列的队列的疯狂值是最小的,他们当然决定按照疯狂值最大的顺序来进行列队。
// 现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。小易老师回来一定会气得半死。

import java.util.Arrays;
import java.util.Scanner;

public class Netease2018_crazyQueue {
    // 将原数列排好序，每次取数列中的最大与最小值加入到疯狂队列中
    // （想象一下疯狂队列从中间向两边扩展），与上一次加入的最小与最大值交叉做差，直到原数列中仅剩最后一个值，
    // 把它放到疯狂队列合适的位置上保证疯狂值最大即可。


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            Arrays.sort(nums);
            int min = nums[0];      // 上一次加入疯狂队列的那个最小值
            int max = nums[n - 1];  // 上一次加入疯狂队列的那个最大值
            int diff = max - min;
            int minIndex = 1;       // 未加入疯狂队列的最小值索引
            int maxIndex = n - 2;   // 未加入疯狂队列的最大值索引
            while (minIndex < maxIndex) {
                diff += max - nums[minIndex];
                diff += nums[maxIndex] - min;
                min = nums[minIndex++];
                max = nums[maxIndex--];
            }
            // 原数列中最后一个数 minIndex == maxIndex，将它放到合适的位置上
            diff += Math.max(nums[maxIndex] - min, max - nums[minIndex]);
            System.out.println(diff);
        }
    }
}

