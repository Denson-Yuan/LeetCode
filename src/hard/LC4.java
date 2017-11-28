package hard;

/**
 * 寻找两个有序数组的中位数
 */

public class LC4 {
    public static void main(String[] args) {
        int[] n1 = {1,3};
        int[] n2 = {2};
        System.out.println(new LC4().findMedianSortedArrays(n1,n2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] nums = new int[len];
        int p = 0, i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] <= nums2[j]) {
                nums[p++] = nums1[i++];
            } else {
                nums[p++] = nums2[j++];
            }
        }
        while (i < len1) {
            nums[p++] = nums1[i++];
        }
        while (j < len2) {
            nums[p++] = nums2[j++];
        }
        if (len % 2 == 1)
            return nums[len / 2];
        else
            return (nums[len / 2] + nums[len / 2 - 1]) / 2.0;
    }
}
