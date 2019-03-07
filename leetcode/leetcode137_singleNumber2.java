package leetcode;

/*
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

        Note:

        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

        Example 1:

        Input: [2,2,3,2]
        Output: 3
        Example 2:

        Input: [0,1,0,1,0,1,99]
        Output: 99*/

public class leetcode137_singleNumber2 {
    public static int singleNumber(int[] A) {
        int ones = 0, twos = 0;

        for (int n : A) {
            ones = (ones ^ n) & ~twos;
            twos = (twos ^ n) & ~ones;
        }
        return ones;
    }


    // 一般形式，其它出现K次
    public static int singleNumberK(int[] nums, int K) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int n : nums) {
                if ((n >> i & 1) == 1) {
                    sum++;
                }
            }
            sum %= K;
            result |= sum << i;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3, 3, 2, 3, 2
        };
        System.out.println(singleNumber(nums));
        System.out.println(singleNumberK(nums, 3));
    }

}
