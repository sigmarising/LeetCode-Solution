package TencentTop50;

public class Problem21 {
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

    private ListNode root = null;
    private ListNode tail = null;

    private void addNode(ListNode addon) {
        addon.next = null;

        if (root == null) {
            root = addon;
        } else {
            tail.next = addon;
        }

        tail = addon;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        root = null;
        tail = null;

        while (l1 != null && l2 != null) {
            ListNode addon;
            if (l1.val <= l2.val) {
                addon = l1;
                l1 = l1.next;
            } else {
                addon = l2;
                l2 = l2.next;
            }
            addNode(addon);
        }

        if (l1 == null) {
            if (tail != null) tail.next = l2;
            else root = l2;
        } else {
            if (tail != null) tail.next = l1;
            else root = l1;
        }

        return root;
    }
}
