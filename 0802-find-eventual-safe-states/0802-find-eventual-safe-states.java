class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverse = new ArrayList<>();

        for(int i=0; i<n; i++){
            reverse.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];

        for(int u=0; u<n; u++){
            for(int v : graph[u]){
                reverse.get(v).add(u);
                inDegree[u] ++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> safeNode = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            safeNode.add(node);

            for(int neighbour : reverse.get(node)){
                inDegree[neighbour] --;

                if(inDegree[neighbour] == 0){
                    q.offer(neighbour);
                }
            }
        }
        Collections.sort(safeNode);
        return safeNode;
    }
}