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
    public List<List<Integer>> levelOrder(TreeNode root) {
         if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                list.add(new LinkedList<>(temp));
                temp = new LinkedList<>();
                if(q.isEmpty()) break;
                q.add(null);
                continue;
            }
            temp.add(node.val);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q. add(node.right);
        }
        return list;
    }
}