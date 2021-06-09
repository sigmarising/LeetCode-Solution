package TencentTop50;

public class Problem26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int fast = 1, slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow += 1;
            }
            fast += 1;
        }

        return slow;

    }
}
