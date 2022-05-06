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
    static class Diameter{
        int value = Integer.MIN_VALUE;
    }
    public int maxD(TreeNode root, Diameter d){
        if(root == null) return 0;
        int left = maxD(root.left, d);
        int right = maxD(root.right, d);
        d.value = Math.max(d.value, left+right); 
        return Math.max(1+left, 1+right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Diameter d = new Diameter();
        maxD(root, d);
        return d.value;
    }
}