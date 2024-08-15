package linkedList;

public class rotateNode61 {
    // 12345   2  变成
    //45123
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        tail.next = head; // Circle the list.


        //k%len的用意是，如果k大于长度，那么其实不需要移动那么多次，直接取模，移动余数那么多步就OK，如果K小于长度，那么结果还是K
        k = k % length;

        int stepsToNewHead = length - k;
        ListNode newTail = tail;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
