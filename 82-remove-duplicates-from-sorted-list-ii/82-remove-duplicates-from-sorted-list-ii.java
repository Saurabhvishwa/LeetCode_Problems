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
        while(head != null){
            if(head.next != null && head.val == head.next.val){
                head = head.next;
                flag = true;
            }
            else{
                if(flag == true){
                    head = head.next;
                    flag = false;
                }else{
                    break;
                }
            }
        }
        ListNode c = head;
        ListNode prev = null;
        while(c != null){
            if(c.next != null && c.val == c.next.val){
                flag = true;
                c.next = c.next.next;
            }else{
                if(flag == true){
                    prev.next = c.next;
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