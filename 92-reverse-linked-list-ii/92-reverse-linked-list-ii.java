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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prevCur = null, cur = head;
        int i = 1;
        while(i<left){
            prevCur = cur;
            cur = cur.next;
            i++;
        }
        ListNode end = cur, prevEnd = null;
        while(i<=right){
            ListNode temp = cur.next;
            cur.next = prevEnd;
            prevEnd = cur;
            cur = temp;
            i++;
        }
        end.next = cur;
        if(prevCur != null){
            prevCur.next = prevEnd;
        }
        return prevCur == null ? prevEnd : head;
    }
}