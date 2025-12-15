package linkedList;

import java.util.HashSet;
import java.util.Set;

public class removeDupNode82 {
    //删除有序链表中的重复
    public ListNode deleteDuplicates(ListNode head) {
        // Create a dummy node that points to the head.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Use 'cur' to traverse the list starting from the dummy node.
        ListNode cur = dummy;

        // While there are at least two nodes ahead to compare.
        while (cur.next != null && cur.next.next != null) {
            // If the next two nodes have the same value, we found duplicates.
            if (cur.next.val == cur.next.next.val) {
                // Remember the duplicate value.
                int duplicateVal = cur.next.val;
                // Skip all nodes with this duplicate value.
                //到这里的时候cur还停留在重复值的最后一位，所以当inner while破除后再次进入outter while
                //就会走到else的逻辑上，实现cur的位移
                while (cur.next != null && cur.next.val == duplicateVal) {
                    cur.next = cur.next.next;
                }
            } else {
                // Otherwise, move cur forward.
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode removeDuplicates(ListNode head) {
        if (head == null) return null;

        Set<Integer> seen = new HashSet<>();
        seen.add(head.val);

        ListNode curr = head;

        while (curr.next != null) {
            if (seen.contains(curr.next.val)) {
                curr.next = curr.next.next; // remove duplicate
            } else {
                seen.add(curr.next.val);
                curr = curr.next;
            }
        }
        return head;
    }
}
