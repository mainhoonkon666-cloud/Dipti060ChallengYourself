
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;

        for (int x : cardPoints) {
            total += x;
        }

        if (k == n) return total;

        int windowSize = n - k;
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minSum = windowSum;

        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i];
            windowSum -= cardPoints[i - windowSize];
            minSum = Math.min(minSum, windowSum);
        }

        return total - minSum;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna