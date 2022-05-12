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
    public int max(TreeNode root, int[] max){
        if(root == null) return 0;
        int left = max(root.left, max);
        int right = max(root.right, max);
        int current = Math.max(root.val, Math.max(left, right)+root.val);
        max[0] = Math.max(max[0], Math.max(current, left+right+root.val));
        return current;
    }
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        max(root, max);
        return max[0];
    }
}