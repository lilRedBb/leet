package linkedList;

public class removeDupNode82 {
    //删除有序链表中的重复
    public ListNode deleteDuplicates(ListNode head) {
        // Step 1: Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Initialize pointers
        ListNode pre = dummy;
        ListNode curr = head;

        while (curr != null) {
            // Step 3: Check for duplicates
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            // Step 4: If pre.next is curr, there were no duplicates for the current value
            if (pre.next == curr) {
                pre = pre.next;
            } else {
                // If duplicates were found, skip all duplicates
                pre.next = curr.next;
            }

            // Move curr forward
            curr = curr.next;
        }

        return dummy.next; // Return the head of the modified list
    }
}
