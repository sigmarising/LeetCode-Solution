package TencentTop50;

import java.util.ArrayList;
import java.util.List;

public class Problem88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                result.add(nums1[i]);
                i++;
            } else {
                result.add(nums2[j]);
                j++;
            }
        }

        if (i == m) while (j < n) {
            result.add(nums2[j]);
            j++;
        }
        else while (i < m) {
            result.add(nums1[i]);
            i++;
        }

        for (i = 0; i < result.size(); i++)
            nums1[i] = result.get(i);
    }
}
