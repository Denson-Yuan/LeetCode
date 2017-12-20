package easy;

/**
 * Given two sorted integer arrays nums1 and nums2
 * merge nums2 into nums1 as one sorted array.
 */
public class LC88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 9, 13, 15, 36, 44, 0, 0, 0};
        int[] nums2 = {5, 25, 45};
        new LC88().merge(nums1, 7, nums2, 3);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 从后往前
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (k >= 0) {
            if (i >= 0 && j >= 0){
                nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
            }
            else if (i >= 0) nums1[k--] = nums1[i--];
            else if (j >= 0) nums1[k--] = nums2[j--];

            /**
             * while (j >= 0) {
             *      nums1[k--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
             * }
             */
        }
    }
}
