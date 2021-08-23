package TencentTop50;

public class Problem169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = -1;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) count += 1;
            else count -= 1;
        }

        return candidate;
    }
}
