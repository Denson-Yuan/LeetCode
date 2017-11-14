import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};   //-4,-1,-1,0,1,2
        System.out.println(new LC15().threeSum1(nums));
        System.out.println(new LC15().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<>();
        if (nums.length < 3) return r;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            int j = i + 1, k = nums.length - 1;
            for (; j < nums.length - 1; j++) {
                if (nums[j] + nums[i] > 0) break;
                for (; k > j; k--) {
                    if (nums[k] + nums[i] + nums[j] < 0) break;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        r.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
                while (k > j && nums[k] == nums[k + 1]) k--;
            }
            while (j < k && nums[j] == nums[j - 1]) j++;
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
