/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int getLength(ListNode head){
        int count = 0;
        ListNode c = head;
        while(c != null){
            count++;
            c = c.next;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int l1 = getLength(headA), l2 = getLength(headB);
        if(l1>l2){
            return getNode(l1-l2, headA, headB);
        }else{
            return getNode(l2-l1, headB, headA);
        }
    }
    public ListNode getNode(int d, ListNode headA, ListNode headB){
        for(int i=0;i<d;i++){
            if(headA == null) return null;
            headA = headA.next;
        }
        while(headA != null && headB != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}