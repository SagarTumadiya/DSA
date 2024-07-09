package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {
    static ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
    static void addEdge(ArrayList<ArrayList<Integer>>adjacencyList,int U,int V){
        adjacencyList.get(U).add(V);
        adjacencyList.get(V).add(U);
    }
    static void bfs(int source,int V){
        boolean[] visited = new boolean[V];
        LinkedList<Integer>queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        while(!queue.isEmpty()){
            source = queue.poll();
            System.out.print(source+" ");
            ArrayList<Integer>list = adjacencyList.get(source);
            for(Integer neighbour:list){
                if(!visited[neighbour]){
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;

        for(int i=0;i<V;i++){
            adjacencyList.add(new ArrayList<Integer>());
        }
        addEdge(adjacencyList, 0, 1);
        addEdge(adjacencyList, 0, 4);
        addEdge(adjacencyList, 1, 2);
        addEdge(adjacencyList, 1, 3);
        addEdge(adjacencyList, 1, 4);
        addEdge(adjacencyList, 2, 3);
        addEdge(adjacencyList, 3, 4);
        bfs(0,V);
    }
}
