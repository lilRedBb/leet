package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cloneGraph133 {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // If the node was already visited, return its clone from the map,这里是为了检测到visi的情况下不再往下走，省时间
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for the current node (with its value but no neighbors yet)
        Node cloneNode = new Node(node.val, new ArrayList<>());

        // Add this node to the visited map
        visited.put(node, cloneNode);

        // Iterate through the neighbors and clone them recursively
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));//如果neigbbor已经被visit，看上面的if，就会返回已经被visit的node的clone，然后放入到list里面
        }

        //这里才是返回最终答案的地方，head的recursive在它自己的for loop + recur的循环整个完成以后才会触发到这里，neighbor没完成就一直卡着，
        //所以不存在返回的结果不是头的情况，因为头回卡到最后
        return cloneNode;
    }
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}


