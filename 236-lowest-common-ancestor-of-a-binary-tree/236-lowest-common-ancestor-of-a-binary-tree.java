/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean f = false, s = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = LCA(root, p , q);
        if(f && s) return ans;
        return null;
    }
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode temp = null;
        if(root.val == p.val) {f=true; temp=root;}
        else if(root.val == q.val) {s=true; temp=root;}
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p ,q );
        if(temp != null) return temp;
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
}