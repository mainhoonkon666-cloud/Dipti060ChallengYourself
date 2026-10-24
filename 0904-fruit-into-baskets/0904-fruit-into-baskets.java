import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int l = 0;
        int maxFruits = 0;

        for (int r = 0; r < fruits.length; r++) {
            basket.put(fruits[r], basket.getOrDefault(fruits[r], 0) + 1);

            while (basket.size() > 2) {
                basket.put(fruits[l], basket.get(fruits[l]) - 1);
                if (basket.get(fruits[l]) == 0) {
                    basket.remove(fruits[l]);
                }
                l++;
            }

            maxFruits = Math.max(maxFruits, r - l + 1);
        }

        return maxFruits;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna