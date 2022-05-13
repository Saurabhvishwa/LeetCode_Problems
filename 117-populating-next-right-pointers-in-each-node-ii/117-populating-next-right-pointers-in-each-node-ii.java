/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public void joinNext(Node root){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current!=null){
                    if(current.left != null) queue.add(current.left);
                    if(current.right != null) queue.add(current.right);
                    while(!queue.isEmpty() && queue.peek() != null){
                    Node next = queue.poll();
                    current.next = next;
                    current = next;
                    if(current.left != null) queue.add(current.left);
                    if(current.right != null) queue.add(current.right);
                    }
                    queue.add(null);
                    queue.poll();
            }
            
            
        }
    }
    public Node connect(Node root) {
        joinNext(root);
        return root;
    }
}