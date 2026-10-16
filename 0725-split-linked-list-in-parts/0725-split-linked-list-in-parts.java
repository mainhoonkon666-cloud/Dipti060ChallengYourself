/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];

        int len = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) {
            len++;
        }

        int baseSize = len / k;
        int extraNodes = len % k;
        ListNode curr = head;

        for (int part = 0; part < k; part++) {
            ans[part] = curr;

            int width = baseSize + (extraNodes > 0 ? 1 : 0);
            if (extraNodes > 0) extraNodes--;

            for (int i = 1; i < width && curr != null; i++) {
                curr = curr.next;
            }

            if (curr != null) {
                ListNode nextPart = curr.next;
                curr.next = null;
                curr = nextPart;
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna