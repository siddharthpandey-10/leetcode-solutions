class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfs(0, graph, path);
        return ans;
    }

    private void dfs(int node, int[][] graph, List<Integer> path){
        
        if(node == graph.length-1){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int next : graph[node]){
            path.add(next);
            dfs(next, graph, path);
            path.remove(path.size() - 1);
        }
    }
}