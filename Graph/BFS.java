import java.io.*;
import java.util.*;

class BFS {
public ArrayList<Integer> bfsOfGraph(int size, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[size];
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int current = q.poll();
            list.add(current);
            ArrayList<Integer> neighbors = adj.get(current);
            for(int el:neighbors){
                if(visited[el] == false){
                    q.add(el);
                    visited[el] = true;
                }
            }
        }
        return list;
    }
}
