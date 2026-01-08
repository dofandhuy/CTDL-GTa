package graph;

import java.util.*;

public class Graph {

    public static void main(String[] args) {
       MyGraph g = new MyGraph();
        g.addNode(new Node('0'));
        g.addNode(new Node('1'));
        g.addNode(new Node('2'));
        g.addNode(new Node('3'));
        g.addNode(new Node('4'));
        g.addNode(new Node('5'));
        g.addNode(new Node('6'));
        g.addNode(new Node('7'));
        g.addEdge(0, 5,6);
        g.addEdge(1, 3,7);
        g.addEdge(1, 7,3);
        g.addEdge(2, 3,2);
        g.addEdge(3, 4,6);
        g.addEdge(3, 1,2);
        g.addEdge(5, 6,1);
        g.addEdge(7, 1,1);
        g.addEdge(7, 4,5);


//boolean isDirected = true;
//        MyGraph<Integer> g = new MyGraph<>(isDirected);
//        
//        g.addNode(1);
//        g.addNode(2);
//        g.addNode(3);
//        g.addNode(4);
//        g.addNode(5);
//        g.addNode(6);
//        g.addNode(7);
//        g.addNode(8);
//        
//        g.addEdge(1, 3);
//        g.addEdge(1, 4);
//        g.addEdge(2, 3);
//        g.addEdge(2, 7);
//        g.addEdge(3,4);
//        g.addEdge(5, 6);
//        g.addEdge(6, 7);
//        g.addEdge(7,8);
//        g.addEdge(8, 1);
//        g.print();
//        g.BFS(1);
//        g.findPathBFS(3,8);
//        System.out.println(g.isConnected());
//        g.addEdge(0, 1, 2);
//        g.addEdge(1, 2, 3);
//        g.addEdge(1, 4, 1);
//        g.addEdge(2, 3, 4);
//        g.addEdge(2, 4, 2);
//        g.addEdge(4, 0, 7);
//        g.addEdge(4, 2, 6);
//
//        g.print();
//
        Map<Integer, Integer> shortestPaths = g.shortestPath(0);
        System.out.println("Shortest paths from 0:");
        for (Map.Entry<Integer, Integer> entry : shortestPaths.entrySet()) {
            System.out.println("To " + (char) ('A' + entry.getKey()) + " -> " + entry.getValue());
        }
    }
}
