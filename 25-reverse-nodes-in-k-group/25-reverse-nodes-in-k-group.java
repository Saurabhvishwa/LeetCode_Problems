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
    public ListNode reverseKGroup(ListNode node, int k) {
        if(node == null) return null;
        ListNode current = node;
        ListNode prev = null, next = null;
        int count = 0;
        int temp = 0;
        ListNode c = node;
        while(c!=null){
            temp++;
            c = c.next;
        }
        if(temp < k){
            return node;
        }
        while(count<k && current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if(next!=null){
            node.next = reverseKGroup(next, k);
        }
        return prev;
    }
}