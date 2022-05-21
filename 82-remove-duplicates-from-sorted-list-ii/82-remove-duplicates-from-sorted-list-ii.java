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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        boolean flag = false;
        ListNode c = head;
        ListNode prev = null;
        while(c != null){
            if(c.next != null && c.val == c.next.val){
                flag = true;
                c.next = c.next.next;
            }else{
                if(flag == true){
                    if(prev != null){
                        prev.next = c.next;
                    }else{
                        head = c.next;
                    }
                    flag = false;
                }else{
                    prev = c;
                }
                c = c.next;
            }
        }
        return head;
    }
}