import java.io.*;
import java.util.*;


class DFS{

    private int V;

    private LinkedList<Integer> adj[];

    DFS(int v){
        this.V = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }

    void addEdge(int v, int w ){
        adj[v].add(w);
    }

    void DFSTraversal(int v,boolean visited[]){

        visited[v] = true;

        System.out.print(" V-"+v);

        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n =i.next();
            if(!visited[n]){
                DFSTraversal(n, visited);
            }
        }
    }

    void DFSCall(int v){
        
        boolean visited[] = new boolean[V];

        DFSTraversal(v, visited);
    }

    public static void main(String[] args) {

        DFS g= new DFS(4);
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 

        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 1)"); 
  
        g.DFSCall(1);

    }





}