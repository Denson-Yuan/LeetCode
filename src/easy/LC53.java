package easy;

/**
 * Maximum Subarray
 */
public class LC53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4, -10, 100};
        System.out.println(new LC53().maxSubArray(nums));
    }

    /**
     * 动态规划公式:
     * maxSoFar(i) = max(maxSoFar(i-1), maxEndingHere(i))
     * MaxEndingHere(i) = max(maxEndingHere(i-1) + A(i), A(i))
     */
    public int maxSubArray(int[] nums) {
        int maxSofar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSofar = Math.max(maxSofar, maxEndingHere);
        }
        return maxSofar;
    }

    /**
     * 分治法：MSA(left,right) = max(MSA(left,medium),MSA(medium,right), MSA(medium))
     * MSA(medium)为包含中间元素往两边扩展的最大和
     * 超时！
     */
    public int maxSubArray1(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public int dfs(int[] nums, int start, int end) {
        if (end == start) return nums[start];
        if (end - start == 1)
            return Math.max(Math.max(nums[start], nums[end]), nums[start] + nums[end]);
        int mid = (start + end) / 2;
        int lmax = nums[mid], rmax = nums[mid], lsum = 0, rsum = 0;
        for (int i = mid; i >= start; i--) {
            lsum += nums[i];
            if (lsum > lmax) lmax = lsum;
        }
        for (int i = mid; i <= end; i++) {
            rsum += nums[i];
            if (rsum > rmax) rmax = rsum;
        }
        int midmax = lmax + rmax - nums[mid];
        return Math.max(Math.max(dfs(nums, start, mid), dfs(nums, mid, nums.length - 1)), midmax);
    }
}
