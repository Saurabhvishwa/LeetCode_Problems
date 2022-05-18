class Solution {
    public void dfs(Map<Integer, List<Integer>> graph, int current, int parent, int[] low, int[] disc, int time, List<List<Integer>> ans){
        disc[current] = low[current] = time++;
        for(Integer v : graph.get(current)){
            if(disc[v] == 0){
                dfs(graph, v, current, low, disc, time, ans);
                low[current] = Math.min(low[current], low[v]);
                if(low[v] > disc[current]){
                    ans.add(Arrays.asList(current, v));
                }
            }else if(v != parent){
                low[current] = Math.min(low[current], disc[v]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i, new ArrayList<Integer>());
        }
        for(List<Integer> l : connections){
            graph.get(l.get(0)).add(l.get(1));
            graph.get(l.get(1)).add(l.get(0));
        }
        int[] low = new int[n], disc = new int[n];
        int time = 1;
        List<List<Integer>> ans = new ArrayList<>();
        dfs(graph, 0, -1, low, disc, time, ans);
        return ans;
    }
}