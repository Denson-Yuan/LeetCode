/**
 * Remove Duplicates from Sorted Array
 * 移除有序数组中的重复元素
 */
public class LC26 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 4, 4, 4};
        System.out.println(new LC26().removeDuplicates(nums));
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int i = 1, j = 1;
        while (j < nums.length) {
            while (j < nums.length && nums[j] == nums[j - 1])
                j++;
            if (j < nums.length) {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i;
    }
}
