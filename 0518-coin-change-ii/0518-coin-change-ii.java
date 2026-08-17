class Solution {
    static int solve(int amount, int [] coins, int index){
        if(amount == 0){
            return 1;
        }
        if(amount < 0){
            return 0;
        }
        if (index >= coins.length) {
            return 0;
        }

        int includeAns = solve(amount - coins[index], coins,index);

        int excludeAns = solve(amount,coins,index+1);

        int finalAns = includeAns + excludeAns;
        return finalAns;
    }
    public int change(int amount, int[] coins) {
        int index = 0;
        int ans = solve(amount,coins,index);
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna