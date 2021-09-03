package DailyChallenge;

import java.util.Arrays;

public class Problem528 {
    class Solution {
        int[] tags;
        int totalSum;

        public Solution(int[] w) {
            tags = new int[w.length];
            tags[0] = w[0];

            for (int i = 1; i < w.length; ++i) {
                tags[i] = tags[i - 1] + w[i];
            }

            totalSum = Arrays.stream(w).sum();
        }

        public int pickIndex() {
            int x = (int) (Math.random() * totalSum) + 1;
            int left = 0, right = tags.length - 1;

            while (left < right) {
                int mid = (right + left) / 2;
                if (tags[mid] < x) left = mid + 1;
                else right = mid;
            }

            return left;
        }
    }
}
