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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        if(len < k){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;

        for (int i = 1; i <= k; i++){
            ListNode ford = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ford;
        }

        //recursion for remaining LL
        ListNode recursionAns = reverseKGroup(curr, k);

        head.next = recursionAns;

        return prev;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna