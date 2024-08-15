package linkedList;

public class reverseLinklist92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing

        for (int i = 0; i < m - 1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 - 3 - 4 - 5 ; m=2; n=4 ---> pre=1, start=2, then=3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5
        //逻辑就是start不变，start每次往右走一格，start原来右边的node，变到自己的左边，然后start再走一格，此时start的右边要走到左边的左边
        //假设我们挪动 1234567 的中间5个
        //1234567
        //1324567
        //1432567
        //1543267
        //1654327

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // First reversing : dummy -> 1 -> 3 -> 2 -> 4 -> 5;
        // Second reversing: dummy -> 1 -> 4 -> 3 -> 2 -> 5;

        return dummy.next;
        /**Pattern:
         Initial Setup:

         pre points to the node before the start of the sublist.
         start points to the first node of the sublist.
         then points to the node right after start.
         Iterative Reversal:

         In each iteration, move the then node to the front of the sublist.
         Adjust the start's next pointer to skip the then node.
         Insert then node right after the pre node.
         Update then to the next node in the original sequence.**/
    }
}
