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
    TreeNode head = null;
    TreeNode prev = null;
    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        prev.right = root;
        prev.left = null;
        prev = root;
        inOrder(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        head = new TreeNode();
       prev = head;
        inOrder(root);
        prev.left = null;
        prev.right = null;
        return head.right;
    }
}