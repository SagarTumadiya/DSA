package Graph;

import java.util.*;

public class DFSIterative {
    static void addEdge(HashMap<Object, TreeSet<Object>> graph,Object u,Object v){
        if(!graph.containsKey(u)){
            graph.put(u,new TreeSet<>());
        }
        if(!graph.containsKey(v)){
            graph.put(v,new TreeSet<>());
        }
        graph.get(u).add(v);
        graph.get(v).add(u);

    }
    static void dfsIterative(Object source,HashMap<Object, TreeSet<Object>> graph){
        List<Object> visitedList = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()){
            source = stack.pop();
            if(!visitedList.contains(source)){
                System.out.print(source+" ");
                visitedList.add(source);
               
            }
            TreeSet<Object>neighbors = graph.get(source);
            for(Object n:neighbors){
                if(!visitedList.contains(n)){
                    stack.push(n);
                }
            }
        }
    }
    public static void main(String[] args) {
        HashMap<Object, TreeSet<Object>> graph = new HashMap<>();
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 4);
        addEdge(graph, 4, 6);
        addEdge(graph, 6, 5);
        addEdge(graph, 5, 3);
        addEdge(graph, 3, 1);
        addEdge(graph, 2, 5);
        addEdge(graph, 4, 5);
        dfsIterative(1,graph);

    }
}
