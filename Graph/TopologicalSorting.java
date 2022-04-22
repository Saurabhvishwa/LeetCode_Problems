// A Java program to print topological
// sorting of a DAG
import java.io.*;
import java.util.*;
class TopologicalSort{
  public void topologicalSortUtil(int v, boolean visited[],
							Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj)
	{
		// Mark the current node as visited.
		visited[v] = true;
		Integer i;

		// Recur for all the vertices adjacent
		// to this vertex
		ArrayList<Integer> it = adj.get(v);
    for(int el: it){
      if(!visited[el]){
        topologicalSortUtil(el, visited, stack, adj); 
      }
    }
    
		// Push current vertex to stack
		// which stores result
		stack.push(new Integer(v));
	}
  
  void topologicalSort()
	{
		Stack<Integer> stack = new Stack<Integer>();

		// Mark all the vertices as not visited
		boolean visited[] = new boolean[V];

		// Call the recursive helper
		// function to store
		// Topological Sort starting
		// from all vertices one by one
		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				topologicalSortUtil(i, visited, stack);

		// Print contents of stack
		while (stack.empty() == false)
			System.out.print(stack.pop() + " ");
	}
}
