package TencentTop50;

public class Problem11 {
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, currentArea);

            if (height[left] < height[right]) left++;
            else right--;
        }

        return ans;
    }
}
