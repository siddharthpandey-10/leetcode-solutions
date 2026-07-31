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
    int depth = 0;
    public int maxDepth(TreeNode root) {
        depth(root);
        return depth;
    }

    private int depth(TreeNode root){
        if(root == null){
            return 1;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        depth = Math.max(depth, Math.max(left, right));
        return Math.max(left, right)+1;
    }
}