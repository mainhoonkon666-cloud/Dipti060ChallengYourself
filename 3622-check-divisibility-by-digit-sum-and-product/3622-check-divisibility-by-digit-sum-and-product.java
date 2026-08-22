class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int sum = 0;
        int product = 1;

        while(num > 0){
            sum += num % 10;
            product *= num % 10;

            num = num/10; 
        }

        if(n % (sum + product) == 0){
            return true;
        }
        return false;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna