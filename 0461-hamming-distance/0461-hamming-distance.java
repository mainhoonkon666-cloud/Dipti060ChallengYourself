class Solution {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;

        int count = 0;

        for(int i = 0; i < 32; i++){
            count += (num & 1);


            num = num >> 1;        
        }

        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna