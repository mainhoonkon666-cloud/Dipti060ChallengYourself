class Solution {
    public int totalHammingDistance(int[] nums) {

        int total = 0;

        for (int bit = 0; bit < 32; bit++) {

            int ones = 0;

            for (int num : nums) {
                if ((num & (1 << bit)) != 0) {
                    ones++;
                }
            }

            int zeros = nums.length - ones;

            total += ones * zeros;
        }

        return total;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna