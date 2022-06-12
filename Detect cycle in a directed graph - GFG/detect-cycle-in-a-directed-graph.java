// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        // int[] visited = new int[V];
        // for(int i=0;i<V;i++){
        //     if(dfs(i, adj, visited)) return true;
        // }
        // return false;
        return bfs(V, adj);
        
    }
    public boolean bfs(int v, ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[v];
        for(ArrayList<Integer> list : adj){
            for(int el : list){
                indegree[el]++;
            }
        }
        // System.out.println(Arrays.toString(indegree));
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i] == 0) q.add(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int el = q.poll();
            count++;
            for(int x : adj.get(el)){
                indegree[x]--;
                if(indegree[x] == 0) q.add(x);
            }
        }
        return count != v;
    }
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited){
        visited[node] = 1;
        for(int el : adj.get(node)){
            if(visited[el] == 0){
                if(dfs(el, adj, visited)) return true;
            }else if(visited[el] == 1) return true;
        }
        visited[node] = 2;
        return false;
    }
}