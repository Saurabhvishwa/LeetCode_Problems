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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int length = 0;
        ListNode current = head;
        while(current != null){
            length++;
            current = current.next;
        }
        length = k%length;
        for(int i=1;i<=length;i++){
            current = head;
            ListNode prev = null;
            while(current.next !=null){
                prev = current;
                current = current.next;
            }
            prev.next = null;
            current.next = head;
            head = current;
        }
        return head;
    }
}