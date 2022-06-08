class Solution {
    public boolean checkFinish(int n, int[][] c){
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<c.length;i++){
            graph.get(c[i][0]).add(c[i][1]);
            indegree[c[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0) q.add(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int el:graph.get(node)){
                indegree[el]--;
                if(indegree[el] == 0) q.add(el);
            }
        }
        return count == n;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // return checkFinish(numCourses, prerequisites);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            List<Integer> temp = graph.getOrDefault(prerequisites[i][0], new ArrayList<>());
            temp.add(prerequisites[i][1]);
            graph.put(prerequisites[i][0], temp);
        }
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<numCourses;i++){
            if(!dfs(i, graph, visited)) return false;
        }
        return true;
    }
    public boolean dfs(int course, Map<Integer, List<Integer>> graph, Set<Integer> visited){
        if(visited.contains(course)) return false;
        if(graph.get(course) == null || graph.get(course).isEmpty()) return true;
        visited.add(course);
        for(int el : graph.get(course)){
            if(!dfs(el, graph, visited)) return false;
        }
        visited.remove(course);
        graph.put(course, null);
        return true;
    }
}  