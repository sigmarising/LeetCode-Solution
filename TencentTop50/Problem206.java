package TencentTop50;

import java.util.List;

public class Problem206 {
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

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode result = null;
        ListNode ptr = head;
        while (ptr != null) {
            ListNode temp = ptr;
            ptr = ptr.next;

            temp.next = result;
            result = temp;
        }

        return result;
    }
}
