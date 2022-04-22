import java.util.*;
import java.io.*;

class DFS{

  public ArrayList<Integer> getDFS(boolean[] visited, int root, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list){
        if(visited[root] == false){
            list.add(root);
            visited[root] = true;
            ArrayList<Integer> neighbors = adj.get(root);
            for(int el:neighbors){
                list = getDFS(visited, el, adj, list);
            }
        }
        return list;
    }
  
}
