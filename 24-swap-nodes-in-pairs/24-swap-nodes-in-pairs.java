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
    public void swapNodes(ListNode n1, ListNode n2){
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
    public ListNode swapPairs(ListNode head) {
        if(head != null && head.next!=null){
            swapNodes(head, head.next);
            swapPairs(head.next.next);
        }
        
       return head;
    }
}