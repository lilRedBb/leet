package linkedList;


import java.util.HashMap;
//deepcopy一个链表，这个链表还有一个random属性，指向Null或者链表中的其他node

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class randomListCopy138 {
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a copy of each node and link them together side-by-side in a single list.
        //A -> A' -> B -> B' -> C -> C' -> null  这样做，下面分random的时候就好操作了，因为原node的random。next， 是random的复制

        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers for the copy nodes.
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Restore the original list, and extract the copy list.
        curr = head;
        Node dummyHead = new Node(0);
        Node copy, copyCurr = dummyHead;
        while (curr != null) {
            copy = curr.next;
            copyCurr.next = copy;
            copyCurr = copy;

            //copy已经转移成功，可以删掉原来List中的copy了
            curr.next = copy.next;
            curr = curr.next;
        }

        return dummyHead.next;
        /**First Iteration:

         copy = curr.next extracts A'.
         copyCurr.next = copy sets dummyHead.next to A'.
         copyCurr = copy moves copyCurr to A'.
         curr.next = copy.next sets A.next to B.
         curr = curr.next moves curr to B.
         Second Iteration:

         copy = curr.next extracts B'.
         copyCurr.next = copy sets A'.next to B'.
         copyCurr = copy moves copyCurr to B'.
         curr.next = copy.next sets B.next to C.
         curr = curr.next moves curr to C.
         **/
    }



    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a copy of each node and store the mapping in a hash map.
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Step 2: Assign next and random pointers to the copied nodes using the hash map.
        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = (curr.next != null) ? map.get(curr.next) : null;
            copy.random = (curr.random != null) ? map.get(curr.random) : null;
            curr = curr.next;
        }

        // Return the head of the copied list.
        return map.get(head);
    }


}


