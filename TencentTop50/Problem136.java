package TencentTop50;

public class Problem136 {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i : nums) {
            result ^= i;
        }

        return result;
    }
}
