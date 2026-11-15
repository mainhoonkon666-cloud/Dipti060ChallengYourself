
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        Arrays.fill(ans, -1);

        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;

            while (!st.isEmpty() && st.peek() <= nums[idx]) {
                st.pop();
            }

            if (i < n && !st.isEmpty()) {
                ans[idx] = st.peek();
            }

            st.push(nums[idx]);
        }

        return ans;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna