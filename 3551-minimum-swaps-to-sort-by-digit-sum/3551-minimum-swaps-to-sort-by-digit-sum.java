import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // pairs[i] = {number, originalIndex}
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> {
            int sumA = digitSum(a[0]);
            int sumB = digitSum(b[0]);

            if (sumA != sumB) return Integer.compare(sumA, sumB);
            return Integer.compare(a[0], b[0]); // tie: smaller number first
        });

        // target[originalIndex] = sorted position
        int[] target = new int[n];
        for (int sortedIndex = 0; sortedIndex < n; sortedIndex++) {
            target[pairs[sortedIndex][1]] = sortedIndex;
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        // Every permutation cycle of length k needs exactly k - 1 swaps.
        for (int i = 0; i < n; i++) {
            if (visited[i] || target[i] == i) continue;

            int cycleLength = 0;
            int cur = i;

            while (!visited[cur]) {
                visited[cur] = true;
                cur = target[cur];
                cycleLength++;
            }

            swaps += cycleLength - 1;
        }

        return swaps;
    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna