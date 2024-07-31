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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode result = new ListNode();
        ListNode head = result;

        int carry = 0;

        while(node1 != null || node2 != null || carry == 1)  {
            int sum = carry + (node1 == null? 0 : node1.val) + (node2 == null ? 0 : node2.val);

            carry = sum / 10;
            result.next = new ListNode();
            result = result.next;
            result.val = sum % 10;

            node1 = node1 != null ? node1.next : node1;
            node2 = node2 != null ? node2.next : node2;
        }

        return head.next;
    }
}