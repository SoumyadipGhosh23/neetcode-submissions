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
    int traverse(TreeNode root, int maxSoFar) {
        if (root == null) {
            return 0;
        }

        int count = 0;

        if (root.val >= maxSoFar) {
            count = 1;
        }

        maxSoFar = Math.max(maxSoFar, root.val);

        count += traverse(root.left, maxSoFar);
        count += traverse(root.right, maxSoFar);

        return count;
    }
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> inorderList = new ArrayList<>();
       return traverse(root, root.val);
    }
}
