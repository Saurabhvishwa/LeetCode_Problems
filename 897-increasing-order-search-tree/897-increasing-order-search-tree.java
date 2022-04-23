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
    TreeNode parent = null;
    public TreeNode getTree(TreeNode root, TreeNode node){
        
        if(root == null){
            return new TreeNode(node.val);
        }
        root.right = getTree(root.right, node);
        return root;
    }
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        increasingBST(root.left);
        parent = getTree(parent, root);
        increasingBST(root.right);
        return parent;
        
    }
}