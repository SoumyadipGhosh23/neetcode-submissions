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

public class Codec {

   public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeHelper(root, sb);
            return sb.toString();
      }

      private void serializeHelper(TreeNode node, StringBuilder sb) {
            if (node == null) {
                  sb.append("null,");
                  return;
            }

            sb.append(node.val).append(",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
      }

  
      // Decodes your encoded data to tree.
      public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0)
                  return null;
            String[] nodes = data.split(",");
            int[] index = new int[] { 0 }; // mutable index wrapper across recursion calls
            return deserializeHelper(nodes, index);
      }

      private TreeNode deserializeHelper(String[] nodes, int[] index) {
            if (index[0] >= nodes.length)
                  return null;

            String val = nodes[index[0]++];

            if (val.equals("null")) {
                  return null;
            }

            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = deserializeHelper(nodes, index);
            node.right = deserializeHelper(nodes, index);

            return node;
      }
}
