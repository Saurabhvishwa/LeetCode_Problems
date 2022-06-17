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
    int cams;
    Set<TreeNode> visited;
    public void dfs(TreeNode root, TreeNode parent){
        if(root != null){
            dfs(root.left, root);
            dfs(root.right, root);
            if((parent == null && !visited.contains(root)) || !visited.contains(root.left) || !visited.contains(root.right)){
                cams++;
                visited.add(parent);
                visited.add(root);
                visited.add(root.left);
                visited.add(root.right);
            }
        }
    }
    public int minCameraCover(TreeNode root) {
        if(root == null) return 0;
        cams = 0;
        visited = new HashSet<>();
        visited.add(null);
        dfs(root, null);
        return cams;
    }
}