/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static class Node{
        TreeNode node;
        int level;
        Node (TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        while(!q.isEmpty()){
            Node node = q.poll();
            TreeNode tNode = node.node;
            if(list.size()<= node.level || list.get(node.level) == null){
                list.add(new ArrayList<>());
                list.get(node.level).add(tNode.val);
            }else list.get(node.level).add(tNode.val);
            if(tNode.left != null) q.add(new Node(tNode.left, node.level+1));
            if(tNode.right != null) q.add(new Node(tNode.right, node.level+1));
        }
        return list;
    }
}