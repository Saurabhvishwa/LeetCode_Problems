/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    StringBuilder serialized = null;
    public String serialize(TreeNode root) {
        serialized = new StringBuilder("");
        serializeTree(root);
        return this.serialized.toString();
    }
    public void serializeTree(TreeNode root){
        if(root == null){
            this.serialized.append("null").append(",");
            return;
        }
        this.serialized.append(root.val).append(",");
        serializeTree(root.left);
        serializeTree(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(values));
        return deserializeTree(q);
    }
    public TreeNode deserializeTree(Queue<String> q){
        String cur = q.poll();
        if(cur.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deserializeTree(q);
        root.right = deserializeTree(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));