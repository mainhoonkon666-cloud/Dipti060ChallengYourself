class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = findBound(nums, target, true);

        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = findBound(nums, target, false);

        return new int[]{first, last};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {

        int low = 0;
        int high = nums.length - 1;
        int result = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {

                result = mid;

                if (isFirst) {
                    high = mid - 1;   // search left
                } else {
                    low = mid + 1;    // search right
                }

            } else if (nums[mid] < target) {

                low = mid + 1;        // go right

            } else {

                high = mid - 1;       // go left
            }
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna