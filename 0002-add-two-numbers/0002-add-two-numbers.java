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
        String num1 = getNumber(l1);
        String num2 = getNumber(l2);

        int arrLen = Math.max(num1.length(), num2.length()) ;
        int[] result = new int[arrLen + 1];

        int[] first = toIntArray(num1, result.length);
        int[] second = toIntArray(num2, result.length);

        ListNode node = new ListNode();
        ListNode head = node;


         for (int i = 0; i < arrLen; i++) {
            int sum = result[i] + first[i] + second[i];
            result[i] = sum % 10;
            result[i+1] = sum / 10;
            node.val = result[i];
            
            if (i == arrLen - 1) {
                if (sum < 10) {
                node.next = null;

                } else {
                    node.next = new ListNode();
                    node.next.val = sum / 10;
                }
                break;
            }
            node.next = new ListNode();
            node = node.next;
        }


        return head;
    }

    public int[] toIntArray(String number, int arraySize) {
        int[] arr = new int[arraySize];

        for (int i = 0, idx = 0; i < number.length() && idx < arraySize; i++, idx++) {
            char c = number.charAt(i);
            if (idx < number.length()) {
                arr[idx] = c - '0';
            } else {
                arr[idx] = 0;
            }
        }
        return arr;
    }

    public String getNumber(ListNode node) {
        StringBuilder sb = new StringBuilder();

        ListNode current = node;
        while (current != null) {
            sb.append(current.val);
            current = current.next;
        }

        return sb.toString();
    }
}