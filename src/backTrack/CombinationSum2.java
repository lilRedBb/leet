package backTrack;

import java.util.*;

public class CombinationSum2 {
    //Each subset needs to be copied into the result list, which takes O(k) time per subset.
    //Since there are O(2ⁿ) subsets, we get O(k × 2ⁿ).
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates efficiently
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // new ArrayList<>(current) --> make a copy of current, not wrap current with a arraylist
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue; // Skip duplicates
            if (candidates[i] > target) break; // Stop if the number exceeds target

            current.add(candidates[i]); // Include the number
            backtrack(candidates, target - candidates[i], i + 1, current, result); // Recur with next index
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> combinations = combinationSum2(candidates, target);
        System.out.println(combinations);
    }
}

