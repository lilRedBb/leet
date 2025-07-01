package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort for pruning
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {  // Base case: valid combination
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break; // Prune unnecessary calls

            combination.add(candidates[i]);  // Choose the number
            backtrack(candidates, target - candidates[i], i, combination, result); // Stay at i (unlimited reuse)
            combination.remove(combination.size() - 1); // Undo choice (backtrack)
            //[2,3,4]找7   [2,2,2]的时候剩下1，break出第三次2带来的recursion，list剪短【2,2】,同时由于break，第二个2的recur的for向下进行，i轮到了3的位置

        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }
}
