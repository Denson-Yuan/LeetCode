import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4, 5, 3, -3, 9, -6};
//        int[] nums = {0, 0, 0, 0};
        System.out.println(new LC15().threeSum1(nums));
        System.out.println(new LC15().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    //超时
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<>();
        if (nums.length < 3) return r;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            int j = i + 1, k = nums.length - 1;
            for (; j < k; j++) {
                if (nums[j] + nums[i] > 0) break;
                k = nums.length - 1;
                for (; k > j; k--) {
                    if (nums[k] + nums[i] + nums[j] < 0) break;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        r.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                    while (k > j && nums[k] == nums[k - 1]) k--;
                }
                while (j < k && nums[j] == nums[j + 1]) j++;
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
        }
        return r;
    }

    //未去重
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        if (nums.length < 3) return r;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        r.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return r;
    }
}
