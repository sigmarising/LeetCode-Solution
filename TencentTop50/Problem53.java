package TencentTop50;

public class Problem53 {
    public int maxSubArray(int[] nums) {
        int bestLastAns = 0, ans = nums[0];
        for (int x : nums) {
            bestLastAns = Math.max(bestLastAns + x, x);
            ans = Math.max(ans, bestLastAns);
        }
        return ans;
    }
}
