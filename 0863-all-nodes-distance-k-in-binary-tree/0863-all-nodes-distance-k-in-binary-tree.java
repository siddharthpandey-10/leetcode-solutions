/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> parent = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        

        buildParent(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);

        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(target);

        int distance = 0;

        while(!q.isEmpty()){
            int size = q.size();
            

            if(distance == k){
                break;
            }

            

            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    q.offer(node.left);
                }

                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    q.offer(node.right);
                }

                if(parent.get(node) != null && !visited.contains(parent.get(node))){
                    visited.add(parent.get(node));
                    q.offer(parent.get(node));
                }
               
            }
            distance ++;
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }

        return ans;
    }

    private void buildParent(TreeNode node, TreeNode par){
        if(node == null){
            return ;
        }
        parent.put(node, par);

        buildParent(node.left, node);
        buildParent(node.right, node);
    }
}