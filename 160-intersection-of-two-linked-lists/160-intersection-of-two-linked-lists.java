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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode cur = headA;
        while(cur != null){
            map.put(cur, 1);
            cur = cur.next;
        }
        cur = headB;
        while(cur != null){
            if(map.containsKey(cur)) return cur;
            cur = cur.next;
        }
        return null;
    }
}