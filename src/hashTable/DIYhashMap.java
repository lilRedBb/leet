package hashTable;


import java.util.ArrayList;

public class DIYhashMap {

    private ArrayList<Node> buckets;
    private static final int SIZE = 1000;

    public DIYhashMap() {
        buckets = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            buckets.add(null);
        }
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets.get(index);
        Node curr = head;

        while(curr!=null){
            if(curr.key==(key)){
                curr.value = value;
                return;
            }
            curr = curr.next;



        }
        Node node = new Node(key,value);
        node.next = head;
        buckets.set(index,node);
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = buckets.get(index);

        while(curr!=null){
            if(curr.key==(key)){
                return curr.value;
            }
            curr = curr.next;

        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets.get(index);
        Node prev = null;
        while(curr!=null){
            if(curr.key!=(key)){
                prev = curr;
                curr = curr.next;
            }else{
                if(prev==null){
                    buckets.set(index,curr.next);
                }else{
                    prev.next = curr.next;
                }
                return;
            }

        }
    }

    private int hash(int key){
        return key % SIZE;
    }
}

class Node {
    int key;
    int value;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }


/**
* Your MyHashMap object will be instantiated and called as such:
* MyHashMap obj = new MyHashMap();
* obj.put(key,value);
* int param_2 = obj.get(key);
* obj.remove(key);
*/
}
