package TencentTop50;

import java.util.ArrayList;
import java.util.List;

public class Problem78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        int total = 1 << n;

        for (int mask = 0; mask < total; mask += 1) {
            temp.clear();

            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    temp.add(nums[i]);
                }
            }

            result.add(new ArrayList<>(temp));
        }

        return result;
    }
}
