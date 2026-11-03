class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] nge = new int[nums2.length];
        Stack<Integer> helperStack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {

            int element = nums2[i];

            while (!helperStack.isEmpty() && helperStack.peek() <= element) {
                helperStack.pop();
            }

            if (helperStack.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = helperStack.peek();
            }

            helperStack.push(element);
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    ans[i] = nge[j];
                    break;
                }
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna