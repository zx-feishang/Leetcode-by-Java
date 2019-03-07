package leetcode;

/*给定两个大小为 m 和 n 的有序数组，要求时间复杂度O（lg（M+N))
假设给定两数组不同时为空*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode4_findMedianSortedArrays {

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }


    public static double findMedianSortedArraysByHeap(int[] nums1, int[] nums2) {
        if (nums1.length < 1 && nums2.length < 1) return 0;
        if (nums1.length < 1)
            return nums2.length % 2 == 1 ? nums2[nums2.length / 2] : (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0;
        if (nums2.length < 1)
            return nums1.length % 2 == 1 ? nums1[nums1.length / 2] : (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0;
        // large小顶堆 small大顶堆
        PriorityQueue<Integer> large = new PriorityQueue<>();
        PriorityQueue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o2 - o1);
            }
        });

        small.add(nums1[0]);
        for (int i = 1; i < nums1.length + nums2.length; i++) {

            if (i < nums1.length) {
                if (nums1[i] < small.peek()) {
                    small.add(nums1[i]);
                } else {
                    large.add(nums1[i]);
                }
            } else {
                if (nums2[i - nums1.length] < small.peek()) {
                    small.add(nums2[i - nums1.length]);
                } else {
                    large.add(nums2[i - nums1.length]);
                }
            }
            if (large.size() - small.size() > 1) {
                small.add(large.poll());
            }
            if (small.size() - large.size() > 1) {
                large.add(small.poll());
            }

        }


        if ((nums1.length + nums2.length) % 2 == 0) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            if (large.size() > small.size()) {
                return large.peek();
            } else {
                return small.peek();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 4, 6};
        int[] nums2 = new int[]{2, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }
}
