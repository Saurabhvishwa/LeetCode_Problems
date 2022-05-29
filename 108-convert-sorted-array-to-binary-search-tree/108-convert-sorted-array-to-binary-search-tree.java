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
    public TreeNode bst(int[] nums, int start, int end){
        int mid = (start+end)/2;
        if(start > end) return null;
        TreeNode node = new TreeNode(nums[mid]);
        if(start == end) return node;
        node.left = bst(nums, start, mid-1);
        node.right = bst(nums, mid+1, end);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums, 0, nums.length-1);
    }
}