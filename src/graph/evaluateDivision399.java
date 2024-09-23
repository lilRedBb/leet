package graph;

import java.util.*;

public class evaluateDivision399 {
    private Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double value = values[i];

            // Create a map entry for A if it doesn't exist
            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());

            // A / B = value
            graph.get(A).put(B, value);
            // B / A = 1 / value (inverse of the division)
            graph.get(B).put(A, 1.0 / value);
        }

        // Process the queries
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String A = queries.get(i).get(0);
            String B = queries.get(i).get(1);

            if (!graph.containsKey(A) || !graph.containsKey(B)) {
                result[i] = -1.0;
            } else {
                result[i] = dfs(A, B, new HashSet<>());
            }
        }
        return result;
    }

    // Depth First Search (DFS) to find the result of A / B
    private double dfs(String A, String B, Set<String> visited) {
        if (A.equals(B)) return 1.0;
        visited.add(A);
        //需要用到dfs的原因是，有时候我们只有a/b  b/c的结果，没有a/c的结果，所以需要用dfs来得到a/c的结果，因为我们是不知道a,c的具体数值的
        Map<String, Double> neighbors = graph.get(A);
        for (String neighbor : neighbors.keySet()) {
            if (visited.contains(neighbor)) continue;
            double product = dfs(neighbor, B, visited);
            if (product != -1.0) {
                return neighbors.get(neighbor) * product;
            }
        }
        //a/b b/c 最后 a进来， 然后 dfs(b,c,visited), 然后是 b进去， dfs(c,c,visited), 得到了1，回溯，1*B.neighbor(c), 最后是
        //1*B.neighbor(c)*A.neighbor(b)
        return -1.0;
    }
}



/**
 * [["a","b"],["b","c"]]
 * means
 * a/b = 2.0
 * b/c = 3.0
 * values [2.0,3.0]
 * queries [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * [6.0,0.5,-1.0,1.0,-1.0]
 * e 和 x 没有被提及过，所以他们的值是没有的，所以没有答案
 * **/
