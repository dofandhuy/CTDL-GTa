/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphdijkstra;

import java.util.*;


/**
 *
 * @author Admin
 */
public class MyGraph<T> {
    private HashMap<T, HashMap<T, Integer>> adj;

    public MyGraph() {
        adj = new HashMap<>();
    }

    public void addNode(T node) {
        adj.putIfAbsent(node, new HashMap<>());
    }

    public void addEdge(T src, T dst, int weight) {
        if (!adj.containsKey(src) || !adj.containsKey(dst)) {
            System.out.println("Lỗi: Một trong các đỉnh chưa được thêm vào đồ thị.");
            return;
        }
        adj.get(src).put(dst, weight);
        adj.get(dst).put(src, weight); // Nếu là đồ thị vô hướng
    }

    public void printGraph() {
        System.out.println("Danh sách cạnh của đồ thị:");
        for (T u : adj.keySet()) {
            System.out.print(u + " -> ");
            for (T v : adj.get(u).keySet()) {
                System.out.print(v + "(" + adj.get(u).get(v) + ") ");
            }
            System.out.println();
        }
    }

    public void dijkstra(T src) {
        if (!adj.containsKey(src)) {
            System.out.println("Lỗi: Đỉnh nguồn không tồn tại.");
            return;
        }

        HashMap<T, Integer> dist = new HashMap<>();
        HashMap<T, T> prev = new HashMap<>();
        PriorityQueue<Map.Entry<T, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (T node : adj.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
            prev.put(node, null);
        }

        dist.put(src, 0);
        pq.add(new AbstractMap.SimpleEntry<>(src, 0));

        while (!pq.isEmpty()) {
            T u = pq.poll().getKey();

            for (T v : adj.get(u).keySet()) {
                int weight = adj.get(u).get(v);
                if (dist.get(u) + weight < dist.get(v)) {
                    dist.put(v, dist.get(u) + weight);
                    prev.put(v, u);
                    pq.add(new AbstractMap.SimpleEntry<>(v, dist.get(v)));
                }
            }
        }

        printPaths(src, dist, prev);
    }

    private void printPaths(T src, HashMap<T, Integer> dist, HashMap<T, T> prev) {
        System.out.println("\nĐường đi ngắn nhất từ " + src + ":");
        for (T dest : adj.keySet()) {
            if (dest.equals(src)) continue;
            if (dist.get(dest) == Integer.MAX_VALUE) {
                System.out.println("Không có đường tới " + dest);
            } else {
                System.out.print("Tới " + dest + " (khoảng cách: " + dist.get(dest) + "): ");
                printPath(dest, prev);
                System.out.println();
            }
        }
    }

    private void printPath(T dest, HashMap<T, T> prev) {
        List<T> path = new ArrayList<>();
        for (T at = dest; at != null; at = prev.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        System.out.println(String.join(" -> ", path.toString()));
    }

    // Kiểm tra liên thông bằng DFS
    public boolean isConnected() {
        if (adj.isEmpty()) return false; // Đồ thị rỗng không liên thông

        Set<T> visited = new HashSet<>();
        T startNode = adj.keySet().iterator().next(); // Lấy một đỉnh bất kỳ
        dfs(startNode, visited);

        return visited.size() == adj.size(); // Nếu đã duyệt hết đỉnh thì đồ thị liên thông
    }

    private void dfs(T node, Set<T> visited) {
        visited.add(node);
        for (T neighbor : adj.get(node).keySet()) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }

}
}