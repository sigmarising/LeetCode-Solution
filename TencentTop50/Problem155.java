package TencentTop50;

import java.util.Stack;

public class Problem155 {
    class MinStack {
        private Stack<Integer> storeStack;
        private Stack<Integer> minStack;

        public MinStack() {
            storeStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            storeStack.push(val);
            if (minStack.isEmpty()) minStack.push(val);
            else {
                int lastMin = minStack.peek();
                if (val <= lastMin)
                    minStack.push(val);
            }
        }

        public void pop() {
            int popInt = storeStack.pop();
            if (popInt == minStack.peek())
                minStack.pop();
        }

        public int top() {
            return storeStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
