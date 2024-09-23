package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class classTable207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build the graph and compute the in-degrees(一个graph用表格的形式记录每一个课的所有prequi
        //                                                      ， 0,123)
        //                                                       1,2
        //                                                       2，3
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int dest = pair[0];
            int src = pair[1];
            graph.get(src).add(dest);
            inDegree[dest]++;//这个表记录每一个课的总共需要的pre的数量
        }

        // Initialize the queue with courses having no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Process the queue，把没有pre的课程拿出来，然后其他的课程的indegree -1
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return count == numCourses;
    }
}
/**Course 0 → Courses 1, 2, 3 (Course 0 is a prerequisite for Courses 1, 2, and 3)
 Course 1 → Courses 2, 3 (Course 1 is a prerequisite for Courses 2 and 3)
 Graph Representation:
 Node 0 points to nodes 1, 2, 3
 Node 1 points to nodes 2, 3
 Node 2 and Node 3 have no outgoing edges in this representation.
 Why Check Neighbors After Polling a Node?
 Initial State:

 Nodes with no prerequisites (e.g., Course 0) are added to the queue.
 Processing Node 0:

 Poll node 0 from the queue.
 Node 0 has outgoing edges to nodes 1, 2, and 3.
 For each neighbor (nodes 1, 2, and 3), decrement their in-degrees.
 Node 1's in-degree is reduced.
 Node 2's in-degree is reduced.
 Node 3's in-degree is reduced.**/
