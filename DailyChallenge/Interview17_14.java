package DailyChallenge;

import java.util.PriorityQueue;

public class Interview17_14 {
    public int[] smallestK(int[] arr, int k) {
        int[] result = new int[k];
        if (k == 0) return result;

        PriorityQueue<Integer> maxRootHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < k; i++) maxRootHeap.offer(arr[i]);
        for (int i = k; i < arr.length; i++)
            if (maxRootHeap.peek() > arr[i]) {
                maxRootHeap.poll();
                maxRootHeap.offer(arr[i]);
            }
        for (int i = 0; i < k; i++) result[i] = maxRootHeap.poll();

        return result;
    }
}
