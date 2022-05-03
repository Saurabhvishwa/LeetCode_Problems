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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        boolean leftRight = true;
        Deque<TreeNode> currentLevel = new LinkedList<>();
        Deque<TreeNode> nextLevel = new LinkedList<>();
        currentLevel.add(root);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = null;
        while(true){
            list = new ArrayList<>();
            while(!currentLevel.isEmpty()){
                
                if(leftRight){
                    TreeNode node = currentLevel.pollFirst();
                        list.add(node.val);
                    if(node.left != null){
                        nextLevel.add(node.left);
                    }
                    if(node.right != null){
                        nextLevel.add(node.right);
                    }
                }else{
                    TreeNode node = currentLevel.pollLast();
                    list.add(node.val);
                    if(node.right != null){
                        nextLevel.addFirst(node.right);
                    }
                    if(node.left != null){
                        nextLevel.addFirst(node.left);
                    }
                }
                
            }
            result.add(list);
            Deque<TreeNode> temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
            leftRight = !leftRight;
            if(currentLevel.isEmpty()) break;
        }
        return result;
    }
}