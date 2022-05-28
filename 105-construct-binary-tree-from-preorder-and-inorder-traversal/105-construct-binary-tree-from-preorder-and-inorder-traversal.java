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
    int index = 0;
    public TreeNode build(int[] pre, int[] in, int start, int end){
        if(start>end) return null;
        TreeNode node = new TreeNode(pre[index++]);
        if(start == end) return node;
        int i = findIndex(in, start, end, node.val);
        node.left = build(pre, in, start, i-1);
        node.right = build(pre, in, i+1, end);
        return node;
    }
    public int findIndex(int[] in, int start, int end, int val){
        int i = 0;
        for(i = start;i<=end;i++){
            if(in[i] == val) return i;
        }
        return i;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length-1);
    }
}