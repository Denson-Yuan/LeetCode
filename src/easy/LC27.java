package easy;

/**
 * Remove Element
 * 从数组中移除元素
 */
public class LC27 {
    public static void main(String[] args) {
        int[] nums = {3};
        System.out.println(new LC27().removeElement(nums, 3));
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            while (i <= j && nums[i] != val) i++;
            while (j >= i && nums[j] == val) j--;
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return i;
    }
}
