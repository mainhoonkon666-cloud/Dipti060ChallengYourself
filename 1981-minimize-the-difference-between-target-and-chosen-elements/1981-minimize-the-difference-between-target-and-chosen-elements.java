class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int maxSum = 70 * mat.length;

        boolean[] dp = new boolean[maxSum + 1];
        dp[0] = true;

        for (int[] row : mat) {
            boolean[] next = new boolean[maxSum + 1];

            for (int sum = 0; sum <= maxSum; sum++) {
                if (!dp[sum]) {
                    continue;
                }

                for (int num : row) {
                    next[sum + num] = true;
                }
            }

            dp = next;
        }

        int ans = Integer.MAX_VALUE;

        for (int sum = 0; sum <= maxSum; sum++) {
            if (dp[sum]) {
                ans = Math.min(ans, Math.abs(sum - target));
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna