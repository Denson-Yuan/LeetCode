import java.util.Arrays;

/**
 * Search Insert Position
 * 采用二分查找
 */
public class LC35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 8, 10, 13, 18, 20, 24};
        System.out.println(new LC35().searchInsert(nums, 1));
    }

    public int searchInsert(int[] nums, int target) {
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
