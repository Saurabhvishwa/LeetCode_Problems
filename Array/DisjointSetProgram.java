/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class DisjointSetProgram
{
    
      int V, E;
    Edge[] edge;
 
    Codechef(int nV, int nE)
    {
        V = nV;
        E = nE;
        edge = new Edge[E];
        for (int i = 0; i < E; i++)
        {
            edge[i] = new Edge();
        }
    }
    
    class Edge{
        int src;
        int dest;
    }
    static class Subset{
        int parent;
        int rank;
        public String toString(){
            return "[parent:"+parent+", rank:"+this.rank+"]";
        }
    }
    
    public static int getRoot(Subset[] subsets, int v){
         if (subsets[v].parent != v)
            subsets[v].parent
                = getRoot(subsets, subsets[v].parent);
        return subsets[v].parent;
    }
    
    public static void Union(Subset[] subsets, int x, int y){
        int xRoot = getRoot(subsets, x);
        int yRoot = getRoot(subsets, y);
        if(subsets[xRoot].rank < subsets[yRoot].rank){
            subsets[xRoot].parent = yRoot;
            
        }else if(subsets[xRoot].rank > subsets[yRoot].rank){
            subsets[yRoot].parent = xRoot;
        }
        else{
            subsets[xRoot].parent = yRoot;
            subsets[yRoot].rank++;
        }
    }
    
    public static boolean checkCycle(DisjointSetProgram graph, int V){
        Subset[] subsets = new Subset[V];
        for(int i=0;i<V;i++){
            subsets[i] = new Subset();
            subsets[i].parent = i;
        }
        for(int i=0;i<graph.edge.length;i++){
            int xRoot = getRoot(subsets, graph.edge[i].src);
            int yRoot = getRoot(subsets, graph.edge[i].dest);
            if(xRoot == yRoot){
                return true;
            }
            Union(subsets, xRoot, yRoot);
        }
        return false;
        
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		 int V = 4, E = 3;
        DisjointSetProgram graph = new DisjointSetProgram(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
 
        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
        System.out.println(checkCycle(graph, V));
	}
}
