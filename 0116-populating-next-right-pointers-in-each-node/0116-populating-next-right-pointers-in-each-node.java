/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/*
Approach 1 BFS
class Solution {
    public Node connect(Node root) {
        
        if(root == null){
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int size = 0;

        while(!q.isEmpty()){
            size = q.size();

            for(int i=0; i<size; i++){
                Node node = q.poll();
                if(i < size-1){
                    node.next = q.peek();
                }

                if(node.left != null){
                    q.offer(node.left);
                }

                if(node.right != null){
                    q.offer(node.right);
                }

            }
        }
        return root;
    }
}
*/

//Approach 2 DFS
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }

        dfs(root);
        return root;
    }
    private void dfs(Node node){
        
        if(node == null || node.left == null){
            return;
        }
        
        node.left.next = node.right;
        
        if(node.next != null){
            node.right.next = node.next.left;
        }
        dfs(node.left);
        dfs(node.right);
    }
}