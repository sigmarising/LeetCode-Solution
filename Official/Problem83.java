package Official;

public class Problem83 {
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

    public ListNode DeleteDuplicates(ListNode head) {
        ListNode i = head;

        while (i != null) {
            ListNode j = i.next;
            while (j != null && j.val == i.val) {
                j = j.next;
                i.next = j;
            }
            i = i.next;
        }

        return head;
    }
}
