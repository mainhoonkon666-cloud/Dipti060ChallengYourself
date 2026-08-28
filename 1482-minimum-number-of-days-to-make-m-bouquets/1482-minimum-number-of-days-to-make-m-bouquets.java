class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;

        if((long) m * k > n) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int day : bloomDay){
            low = Math.min(low, day);
            high = Math.max(high, day);
        }


        while (low <= high){
            int mid = low + (high - low) / 2;

            if(canMake(bloomDay, mid, m, k)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canMake(int [] bloomDay, int day, int m, int k){
        int bouquets = 0;
        int flowers = 0;
        for(int bloom : bloomDay){
            if(bloom <= day){
                flowers ++;
                
                if(flowers == k){
                    bouquets++;
                    flowers = 0;
                    
                    if(bouquets >= m) return true;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna