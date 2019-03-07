package leetcode;

// 原位置合并两个有序数组
public class leetcode88_mergeInPlace {
    public static int[] mergeWithSpace(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            temp[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < m) {
            temp[k++] = nums1[i++];
        }
        while (j < n) {
            temp[k++] = nums2[j++];
        }
        return temp;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 4, 6, 9, 0, 0, 0, 0, 0, 0};
        int[] num2 = new int[]{3, 5, 7, 8, 10, 11};
        merge(num1, 5, num2, num2.length);
        for (int p : num1) {
            System.out.print(p + " ");
        }
    }

}


