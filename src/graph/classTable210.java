package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class classTable210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create graph and in-degree array
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the graph and in-degree array
        for (int[] pre : prerequisites) {
            int u = pre[1];
            int v = pre[0];
            graph[u].add(v);
            inDegrees[v]++;
        }

        // Initialize queue for nodes with 0 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        //in degree最不

        // Perform BFS to determine course order
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result[index++] = curr;
            //被最多课作为前置的课，indegree就最多，这里放queue里面的是最不被当做前置课的
            for (int next : graph[curr]) {
                //拿到queue poll出来的课的 前置课
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // If we processed all courses, return result; otherwise return empty array
        return index == numCourses ? result : new int[0];
    }
}
