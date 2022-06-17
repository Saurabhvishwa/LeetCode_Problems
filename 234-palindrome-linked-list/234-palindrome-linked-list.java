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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        StringBuilder sb = new StringBuilder("");
        ListNode cur = head;
        while(cur != null){
            sb.append(cur.val);
            cur = cur.next;
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}