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
    List<Integer> list = null;
    public void inorder(TreeNode root){
        TreeNode current = root;
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        while(current != null || !st.isEmpty()){
            while(current != null){
                st.push(current);
                current = current.left;
            }
            current = st.pop();
            list.add(current.val);
            current = current.right;
        }
    }
    // public void inorder(TreeNode root){
    //     if(root == null) return;
    //     inorder(root.left);
    //     list.add(root.val);
    //     inorder(root.right);
    // }
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new LinkedList<>();
        inorder(root);
        return list;
    }
}