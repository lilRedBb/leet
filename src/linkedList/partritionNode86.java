package linkedList;

public class partritionNode86 {

    //143252
    //x=3
    //122435
    //把小于3的都放到大于等于3的前面
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode after = afterHead;
//before he after = head的原因是，当第一次before和after和 head这个链表建联后，beforehead和afterhead就已经可以找到介入head了
        //把 before after 设为head就是在不增加node的基础上，重塑head链表的链接关系，这样head链表就从本身上断成了两个链表
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = head; //因为before后面是没东西的，把before.next设为head后，再用before=head就是before=before.next了
            } else {
                after.next = head;
                after = head;
            }
            head = head.next;
        }

        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }
}
