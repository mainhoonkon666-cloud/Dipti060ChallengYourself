/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// LeetCode 138: Copy List with Random Pointer
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 1. Insert copied nodes directly after original nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // 2. Set random pointers for copied nodes
        curr = head;
        while (curr != null) {
            Node copy = curr.next;
            copy.random = (curr.random == null) ? null : curr.random.next;
            curr = copy.next;
        }

        // 3. Separate original and copied lists
        curr = head;
        Node copyHead = head.next;

        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;
            copy.next = (copy.next == null) ? null : copy.next.next;
            curr = curr.next;
        }

        return copyHead;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna