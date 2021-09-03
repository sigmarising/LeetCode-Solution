package DailyChallenge;

public class Sword2Offer22 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;

        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++)
            if (fast != null) fast = fast.next;
            else break;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
