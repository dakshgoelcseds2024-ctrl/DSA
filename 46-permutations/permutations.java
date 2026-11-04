import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Base case: permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Skip already used numbers
            if (current.contains(nums[i])) {
                continue;
            }

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(nums, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}
