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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root, p, q);
    }
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        TreeNode temp = null;
        if(root.val == p.val){
            temp = root;
        }else if(root.val == q.val) temp = root;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if(temp != null) return temp;
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
}