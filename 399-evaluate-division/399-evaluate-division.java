class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String start = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            
            if(graph.containsKey(start)){
                graph.get(start).put(dest, values[i]);
            }else{
                HashMap<String, Double> temp = new HashMap<>();
                temp.put(dest, values[i]);
                graph.put(start, temp);
            }
            
            if(graph.containsKey(dest)){
                graph.get(dest).put(start, 1/values[i]);
            }else{
                HashMap<String, Double> temp = new HashMap<>();
                temp.put(start, 1/values[i]);
                graph.put(dest, temp);
            }
            
        }
        
        double[] ans = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            HashSet<String> visited = new HashSet<>();
            ans[i] = DFS(graph, queries.get(i).get(0), queries.get(i).get(1), visited);
        }
        
        return ans;
        
    }
    public double DFS(HashMap<String, HashMap<String, Double>> graph, String src, String dest, HashSet<String> visited){
        
        if(!graph.containsKey(src)) return -1.0;
        
        if(graph.get(src).containsKey(dest)) return graph.get(src).get(dest);
        
        visited.add(src);
        
        for(Map.Entry<String, Double> entry: graph.get(src).entrySet()){
            if(!visited.contains(entry.getKey())){
                double ans = DFS(graph, entry.getKey(), dest, visited);
                if(ans != -1){
                    return (ans*entry.getValue());
                }
            }
        }
        
        return -1.0;
    }
}