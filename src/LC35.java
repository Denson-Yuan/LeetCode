/**
 * Search Insert Position
 * 采用二分查找
 */

import java.util.Arrays;

public class LC35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 8, 10, 13, 18, 20, 24};
        System.out.println(new LC35().searchInsert(nums, 30));
    }

    /**
     * 自定义二分查找
     */
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        if (end - start <= 1) {
            if (target <= nums[start]) return start;
            if (target > nums[end]) return end + 1;
            return start + 1;
        }
        int mid = (start + end) / 2;
        if (target == nums[mid])
            return mid;
        if (target < nums[mid])
            return binarySearch(nums, start, mid, target);

        return binarySearch(nums, mid, end, target);
    }

    /**
     * 二分查找库函数
     */
    public int searchInsert2(int[] nums, int target) {
        int r = Arrays.binarySearch(nums, target);
        return r >= 0 ? r : -r - 1;
    }

    /**
     * 顺序查找
     */
    public int searchInsert1(int[] nums, int target) {
        if (target < nums[0]) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) return i;
            if (target > nums[i] && i + 1 < nums.length && target < nums[i + 1]) return i + 1;
        }
        return nums.length;
    }
}
