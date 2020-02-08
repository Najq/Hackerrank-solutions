import java.io.*; 
import java.util.*;

import jdk.javadoc.internal.doclets.formats.html.markup.Links; 
  
class BFS 
{ 
	private int V; 
	private LinkedList<Integer> adj[]; 

	
	BFS(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	void addEdge(int v,int w) 
	{ 
		adj[v].add(w); 
	} 

	void BFS_traversal(int s) 
	{ 
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(vertex+" ");

            Iterator<Integer> i = adj[vertex].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n]= true;
                    queue.add(n);
                }
            }
        }

	} 

	
	public static void main(String args[]) 
	{ 
		BFS g = new BFS(4); 

		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 3); 

		System.out.println("Following is Breadth First Traversal "+"(starting from vertex 2)"); 

		g.BFS_traversal(2); 
	} 
} 

