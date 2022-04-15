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
    public static TreeNode parent;
    public TreeNode insert(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(val<root.val){
            root.left = insert(root.left,val);
        }
        else if(val>root.val){
            root.right = insert(root.right, val);
        }
        return root;
    }
    public void trimTree(TreeNode root, int low, int high){
        if(root == null) return;
        if(root.val>=low && root.val<=high){
            parent = insert(parent, root.val);
        }
        trimTree(root.left, low, high);
        trimTree(root.right, low, high);
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        parent = null;
        trimTree(root, low, high);
        return parent;
    }
}