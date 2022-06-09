class Solution {
    Stack<Integer> order;
    boolean isPossible;
    public int[] topologicalSort(int n, int[][] courses){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] course : courses){
            int u = course[0], v = course[1];
            List<Integer> temp = graph.getOrDefault(v, new ArrayList<>());
            temp.add(u);
            graph.put(v, temp);
        }
        int[] visited = new int[n];
        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                dfs(i, graph, visited);
            }
            
        }
        if(isPossible){
            int[] ans = new int[n];
            int index = 0;
            while(!order.isEmpty()){
                ans[index++] = order.pop();
            }
            return ans;
        }else return new int[0];
    }
    public void dfs(int node, Map<Integer, List<Integer>> graph, int[] visited){
       if(isPossible == false) return;
        visited[node] = 1;
        for(int el : graph.getOrDefault(node, new ArrayList<>())){
            if(visited[el] == 0){
                dfs(el, graph, visited);
            }else if(visited[el] == 1){
                isPossible = false;
            }
        }
        visited[node] = 2;
        order.push(node);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        isPossible = true;
        order = new Stack<>();
        return topologicalSort(numCourses, prerequisites);
    }
}