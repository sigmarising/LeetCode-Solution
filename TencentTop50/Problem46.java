package TencentTop50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tempArray = new ArrayList<Integer>();
        for (int num : nums)
            tempArray.add(num);

        backTrack(result, tempArray, 0, nums.length);
        return result;
    }

    public void backTrack(List<List<Integer>> result, List<Integer> temp, int pointer, int totalLen) {
        if (pointer == totalLen)
            result.add(new ArrayList<Integer>(temp));

        for (int i = pointer; i < totalLen; i++) {
            Collections.swap(temp, pointer, i);
            backTrack(result, temp, pointer + 1, totalLen);
            Collections.swap(temp, pointer, i);
        }
    }
}
