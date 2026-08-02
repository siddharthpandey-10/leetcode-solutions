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

    int xLevel = -1;
    int yLevel = -1;
    TreeNode xParent = null;
    TreeNode yParent = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return xLevel == yLevel && xParent != yParent;
    }

    private void dfs(TreeNode node, TreeNode parent, int level, int x, int y){

         if(node == null){
            return;
        }

        if(node.val == x){
            xLevel = level;
            xParent = parent;
        }

        if(node.val == y){
            yLevel = level;
            yParent = parent;
        }

        dfs(node.left, node, level+1, x, y);
        dfs(node.right, node, level+1, x, y);
    }
}