class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> resultList = new ArrayList<>();

        backtrack(resultList, new ArrayList<>(), nums, 0);

        return resultList;
    }

    private void backtrack(List<List<Integer>> resultSets,
                           List<Integer> tempSet,
                           int[] nums,
                           int start) {

        resultSets.add(new ArrayList<>(tempSet));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicate elements at the same level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            tempSet.add(nums[i]);

            backtrack(resultSets, tempSet, nums, i + 1);

            tempSet.remove(tempSet.size() - 1);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna