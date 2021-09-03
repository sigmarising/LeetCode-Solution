package DailyChallenge;

import java.util.PriorityQueue;

public class Problem295 {
    class MedianFinder {
        private PriorityQueue<Integer> leftHeap; // Max Top Heap
        private PriorityQueue<Integer> rightHeap; // Min Top Heap

        public MedianFinder() {
            leftHeap = new PriorityQueue<Integer>((a, b) -> (b - a));
            rightHeap = new PriorityQueue<Integer>((a, b) -> (a - b));
        }

        public void addNum(int num) {
            if (rightHeap.isEmpty() || num >= rightHeap.peek()) {
                rightHeap.offer(num);
                if (leftHeap.size() + 1 < rightHeap.size())
                    leftHeap.offer(rightHeap.poll());
            } else {
                leftHeap.offer(num);
                if (leftHeap.size() > rightHeap.size())
                    rightHeap.offer(leftHeap.poll());
            }
        }

        public double findMedian() {
            if (rightHeap.size() > leftHeap.size())
                return rightHeap.peek();
            else
                return (rightHeap.peek() + leftHeap.peek()) / 2.0;
        }
    }
}
