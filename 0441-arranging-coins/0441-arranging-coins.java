class Solution {
    public int arrangeCoins(int n) {
        long low = 0;
        long high = n;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            long coins = mid * (mid + 1) / 2;

            if (coins == n) {
                return (int) mid;
            } 
            else if (coins < n) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return (int) high;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna