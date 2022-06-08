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
        return checkFinish(numCourses, prerequisites);
    }
}  