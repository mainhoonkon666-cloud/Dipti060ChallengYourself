class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            // Convert character to 1-based digit value: 'A' -> 1, 'B' -> 2, ..., 'Z' -> 26
            int d = c - 'A' + 1;
            // Shift current result by base 26 and add the digit value
            result = result * 26 + d;
        }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna