package TencentTop50;

import java.util.Arrays;

public class Problem16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 10000000;

        for (int i = 0; i < nums.length; i++) {
            if (i !=0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == target) return target;
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
                if (sum > target) {
                    int tempK = nums[k];
                    while (j < k && nums[k] == tempK) k--;
                } else {
                    int tempJ = nums[j];
                    while (j < k && nums[j] == tempJ) j++;
                }
            }
        }

        return result;
    }
}
