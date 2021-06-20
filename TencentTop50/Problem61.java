package TencentTop50;

public class Problem61 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        int t = k % n;
        t = n - t;
        tail.next = head;
        for (int i = 1; i < t; i++) {
            head = head.next;
        }

        ListNode result = head.next;
        head.next = null;

        return result;
    }
}
