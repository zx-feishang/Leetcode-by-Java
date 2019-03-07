package leetcode;

// 找众数，出现次数大于n/2
import java.util.Arrays;

public class leetcode169_majorityElement {


    public static int majorityElement(int[] nums) {
        int count = 0;
        int majority = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count++;
            } else if (majority == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }


    public static int majorityElementBySort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 2, 3, 3, 3, 3, 3};
        System.out.println(majorityElement(nums));
        for (int temp : nums) {
            System.out.print(temp + " ");
        }
    }
}
