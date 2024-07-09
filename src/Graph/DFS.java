package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {
    static ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
    static int V = 5;
    static void addEdge(ArrayList<ArrayList<Integer>>adjacencyList,int U,int V){
        adjacencyList.get(U).add(V);
        adjacencyList.get(V).add(U);
    }

    static void dfs(int source){
       boolean[] visited = new boolean[V];
       dfsUtility(source,visited);
    }
    static void dfsUtility(int source,boolean[] visited){
        visited[source] = true;
        System.out.print(source+" ");
        ArrayList<Integer>list = adjacencyList.get(source);
        for(Integer n:list){
            if(!visited[n]){
                dfsUtility(n,visited);
            }
        }

    }
    public static void main(String[] args) {

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
        dfs(0);
    }
}
