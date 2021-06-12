package TencentTop50;

public class Problem23 {
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

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode tail = null;

        while (l1 != null && l2 != null) {
            ListNode addon;
            if (l1.val <= l2.val) {
                addon = l1;
                l1 = l1.next;
            } else {
                addon = l2;
                l2 = l2.next;
            }

            addon.next = null;
            if (root == null) {
                root = addon;
            } else {
                tail.next = addon;
            }
            tail = addon;
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

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];

        if (left > right) return null;

        int mid = (left + right) / 2;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
}
