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
    void inorder(TreeNode root, List<Integer> inorderList) {
        if (root == null) {
            return;
        }

        inorder(root.left, inorderList); // Visit left subtree
        inorderList.add(root.val); // Visit root
        inorder(root.right, inorderList); // Visit right subtree
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);

        if (k <= 0 || k > inorderList.size()) {
            return -1;
        }

        // Return the k-th smallest element (1-based index)
        return inorderList.get(k - 1);
    }
}
