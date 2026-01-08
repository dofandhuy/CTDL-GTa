/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graphdijkstra;

import java.util.Map;

/**
 *
 * @author Admin
 */
public class GraphDijkstra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     MyGraph<String> g = new MyGraph<>();

        // Thêm đỉnh với dữ liệu bất kỳ
        g.addNode("A");
        g.addNode("3");
        g.addNode("C");
        g.addNode("6");
        g.addNode("E");

        // Thêm cạnh có trọng số
        g.addEdge("A", "3", 2);
        g.addEdge("3", "C", 3);
        g.addEdge("3", "E", 1);
        g.addEdge("C", "6", 4);
        g.addEdge("C", "E", 2);
        g.addEdge("E", "A", 7);
        g.addEdge("E", "C", 6);

        // In đồ thị trước khi chạy thuật toán
        g.printGraph();

        // Chạy Dijkstra từ đỉnh "A"
        g.dijkstra("A");
    }
    }
    
    

