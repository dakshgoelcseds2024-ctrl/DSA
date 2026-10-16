import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        findCombinations(candidates, target, 0,
                         new ArrayList<>(), result);

        return result;                                                       
    }

    private void findCombinations(int[] candidates, int target,
                                  int index, List<Integer> current,
                                  List<List<Integer>> result) {

        // Target achieved
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try each candidate from the current index
        for (int i = index; i < candidates.length; i++) {

            if (candidates[i] > target) {
                continue;
            }

            // Choose the number
            current.add(candidates[i]);

            // Same number can be used again
            findCombinations(candidates, target - candidates[i],
                             i, current, result);

            // Backtrack: remove the chosen number
            current.remove(current.size() - 1);
        }
    }
}
