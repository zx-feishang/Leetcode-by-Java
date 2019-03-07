package leetcode;

public class leetcode136_singleNumber {
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {
            1, 2, 1, 3, 5, 5, 3
        }));
    }
}
