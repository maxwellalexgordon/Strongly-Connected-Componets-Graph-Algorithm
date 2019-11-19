import java.util.*;

public class graph {

    int V = 0;
    LinkedList<Integer> adj[];
    Stack<Integer> stack = new Stack<>();

    public graph(int ver) {
        V = ver;

        adj = new LinkedList[ver];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }

    }

    public void addEdge(int v, int n) {
        adj[v].add(n);
    }

    public void DFS(boolean[] vis, int vertex) {no
        vis[vertex] = true;
        System.out.println(vertex);
        // loop through all Vertex connections
        for (Integer newV : adj[vertex]) {
            if (vis[newV] == false) {
                DFS(vis, newV);
            }
        }
        stack.add(vertex);
    }


    public graph transpose() {
        graph newGraph = new graph(V);
        for (int i = 0; i < V; i++) {
            Iterator<Integer> t = adj[i].listIterator();

            while (t.hasNext()) {
                newGraph.adj[t.next()].add(i);

            }
        }
        return newGraph;

    }

    public void altDFS(boolean[] vis, int vertex) {
        vis[vertex] = true;
        System.out.println(vertex);


        // loop through all Vertex connections
        for (Integer newV : adj[vertex]) {
            if (vis[newV] == false) {
                DFS(vis, newV);
            }
        }
    }


    public void fullConstrained() {
        //call dsf

        //empty list
        boolean[] vis = new boolean[V];
        for (int i = 0; i < vis.length; i++) {
            vis[i] = false;
        }
        System.out.println("------DSF first time--------");
        //start dsf on 0
		for (int i = 0; i < V ; i++) {
			if(vis[i] == false){
				DFS(vis, i);
			}
		}



        System.out.println("-----DSF seconds time---------");

        //transpose graphs
        graph newGraph = transpose();

        //run dsf on stack on transposed graphs
        for (int i = 0; i < vis.length; i++) {
            vis[i] = false;
        }

        while (!stack.isEmpty()) {
            int next = stack.pop();
            if (vis[next] == false) {
                newGraph.altDFS(vis, next);  //need non general form, pop off when using
                System.out.println("--");
            }
        }

    }


}
