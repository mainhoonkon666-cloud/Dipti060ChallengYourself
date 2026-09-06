class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 1;
        long high = num;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;
            } 
            else if (square < num) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna