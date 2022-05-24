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
    public void sum(TreeNode root, int num, int[] sum){
        if(root == null) return;
        int number = num*10 + root.val;
        if(root.left == null && root.right == null){
            sum[0] += number;
            System.out.println(number);
            return;
        }
        sum(root.left, number, sum);
        sum(root.right, number, sum);
    }
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        sum(root, 0, sum);
        return sum[0];
    }
}