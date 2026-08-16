class Solution {
    static int solve(int[] nums, int index, int[] dp) {
        if (index >= nums.length)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int include = nums[index] + solve(nums, index + 2, dp);
        int exclude = solve(nums, index + 1, dp);

        return dp[index] = Math.max(include, exclude);
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(nums, 0, dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna