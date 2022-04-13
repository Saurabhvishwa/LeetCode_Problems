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
class NodeComparator implements Comparator<ListNode>{
    public int compare(ListNode n1, ListNode n2){
        if(n1.val>n2.val){
            return 1;
        }else if(n1.val<n2.val){
            return -1;
        }
        return 0;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new NodeComparator());
        int k = lists.length;
        ListNode head = new ListNode(0);
        ListNode last = head;
        
        for(int i=0;i<k;i++){
            if(lists[i] != null){
                queue.add(lists[i]);
            }
        }
        if(queue.isEmpty()){
            return null;
        }
        while(!queue.isEmpty()){
            ListNode curr = queue.poll();
            last.next = curr;
            last = last.next;
            if(curr.next!=null){
                queue.add(curr.next);
            }
        }
        return head.next;
    }
}