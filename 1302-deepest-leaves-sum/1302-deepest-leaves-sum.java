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
    public int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(1+depth(root.left), 1+depth(root.right));
    }
    public void deepSum(TreeNode root, int d, int[] sum, int depth){
        if(depth == d){
            sum[0] += root.val;
        }
        if(root.left != null){
            deepSum(root.left, d+1, sum, depth);
        }
        if(root.right != null){
            deepSum(root.right, d+1, sum, depth);
        }
    }
    public int deepestLeavesSum(TreeNode root) {
        int depth = depth(root);
        int[] ans = {0};
        deepSum(root, 1, ans, depth);
        return ans[0];
    }
}