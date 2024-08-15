package linkedList;

public class removeLastNnode19 {
    //删除倒数第n个节点
    //快慢针，一个先走n步，然后一起走，fast到底了，那slow就到需要删除的前一个node， node.next = node.next.next
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Initialize two pointers, both starting at the dummy node
        ListNode first = dummy;
        ListNode second = dummy;

        // Step 3: Move the first pointer n+1 steps ahead to maintain the gap
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Step 4: Move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Step 5: Remove the nth node from the end
        second.next = second.next.next;

        return dummy.next; // Return the head of the modified list
    }
}
