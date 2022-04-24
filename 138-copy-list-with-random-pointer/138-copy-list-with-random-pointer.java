/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node current = head;
        Map<Node, Node> map = new HashMap<>();
        while(current != null){
            map.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        Node currentCloned = null;
        while(current != null){
            if(currentCloned == null){
                currentCloned = map.get(current);
            }else{
                currentCloned.next = map.get(current);
                currentCloned = currentCloned.next;
                
            }
            if(current.random != null){
                currentCloned.random = map.get(current.random);
            }
            current = current.next;
        }
        return map.get(head);
    }
}