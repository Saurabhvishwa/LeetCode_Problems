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
    public int length(ListNode head){
        int size = 0;
        while(head!=null){
            size++;
            head = head.next;
        }
        return size;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = length(head);
        if(n>length) return head;
        if(length == n){
            return head.next;
        }
        int index = 1;
        ListNode root = head;
        while(index<length-n){
            index++;
            root = root.next;
        }
        root.next = root.next.next;
        return head;
        
        
    }
}