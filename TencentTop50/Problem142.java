package TencentTop50;

import java.util.List;

public class Problem142 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    private ListNode findEntry(ListNode head, ListNode slow) {
        ListNode ptr = head;

        while (ptr != slow) {
            ptr = ptr.next;
            slow = slow.next;
        }

        return ptr;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (fast == slow) {
                return findEntry(head, slow);
            }
        }

        return null;
    }

}
