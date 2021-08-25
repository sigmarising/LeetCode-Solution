package TencentTop50;

import java.util.HashSet;
import java.util.Set;

public class Problem217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums)
            if (numSet.contains(num))
                return true;
            else
                numSet.add(num);

        return false;
    }
}
