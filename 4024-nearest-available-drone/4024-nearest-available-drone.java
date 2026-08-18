class Solution {
    public int nearestDrone(int[][] drones, int[] target) {

        int ans = -1;
        int minDistance = Integer.MAX_VALUE;

        int tx = target[0];
        int ty = target[1];

        for (int i = 0; i < drones.length; i++) {

            int x = drones[i][0];
            int y = drones[i][1];
            int range = drones[i][2];

            int distance = Math.abs(x - tx) + Math.abs(y - ty);

            if (distance <= range) {

                if (distance < minDistance) {
                    minDistance = distance;
                    ans = i;
                }
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna