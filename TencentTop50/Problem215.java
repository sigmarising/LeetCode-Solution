package TencentTop50;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((Comparator<Integer>) (a, b) -> b - a);

        for (int i : nums)
            maxHeap.offer(i);

        for (int i = 0; i < k - 1; i++)
            maxHeap.poll();

        return maxHeap.peek();
    }
}
