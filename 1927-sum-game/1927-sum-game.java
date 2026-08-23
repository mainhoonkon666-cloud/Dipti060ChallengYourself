class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftSum = 0;
        int rightSum = 0;
        int leftQ = 0;
        int rightQ = 0;

        // Step 1: Find sums and '?' counts in each half
        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            if (ch == '?') {
                if (i < n / 2) {
                    leftQ++;
                } else {
                    rightQ++;
                }
            } else {
                int digit = ch - '0';

                if (i < n / 2) {
                    leftSum += digit;
                } else {
                    rightSum += digit;
                }
            }
        }

        // Step 2: Odd number of '?' means Alice wins
        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        // Step 3: Bob wins only if he can perfectly balance both halves
        return 2 * (leftSum - rightSum) != 9 * (rightQ - leftQ);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna