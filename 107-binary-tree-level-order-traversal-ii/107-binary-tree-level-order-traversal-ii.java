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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                ans.add(0,new ArrayList<>(list));
                list = new ArrayList<>();
                if(q.isEmpty()) break;
                q.add(null);
                continue;
            }
            list.add(node.val);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return ans;
    }
}