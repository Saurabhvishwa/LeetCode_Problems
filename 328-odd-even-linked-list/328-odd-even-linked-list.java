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
    public ListNode oddEvenList(ListNode head) {
        ListNode even = new ListNode(), odd = new ListNode();
        ListNode e = even, o = odd;
        boolean isOdd = true;
        while(head != null){
            if(isOdd){
                o.next = head;
                o = o.next;
            }else{
                e.next = head;
                e = e.next;
            }
            isOdd = !isOdd;
            head = head.next;
        }
        e.next = null;
        o.next = even.next;
        return odd.next;
    }
}