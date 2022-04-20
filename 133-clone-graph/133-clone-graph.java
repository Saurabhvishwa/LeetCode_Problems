/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        while(!q.isEmpty()){
            Node current = q.poll();
            Node clonedCurrent = map.get(current);
            if(current.neighbors!=null){
                for(Node nodeItr:current.neighbors){
                    Node clonedNode = map.get(nodeItr);
                    if(clonedNode == null){
                        q.add(nodeItr);
                        clonedNode = new Node(nodeItr.val);
                        map.put(nodeItr, clonedNode);
                        
                    }
                    clonedCurrent.neighbors.add(clonedNode);
                }
            }
        }
        return map.get(node);
    }
}