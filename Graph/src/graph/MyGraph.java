/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.*;

public class MyGraph {

    ArrayList<LinkedList<Node>> aslist;
    private HashMap<Integer, HashMap<Integer, Integer>> weights;

    MyGraph() {
        aslist = new ArrayList<>();
        weights = new HashMap<>();
    }

//    public void addEdge(int src, int dst) {
//        LinkedList<Node> current = aslist.get(src);
//        Node dstNode = aslist.get(dst).get(0);
//        current.add(dstNode);
//    }
    public void addEdge(int src, int dst, int weight) {
        LinkedList<Node> current = aslist.get(src);
        Node dstNode = aslist.get(dst).get(0);
        current.add(dstNode);
        weights.get(src).put(dst, weight);
    }

    public boolean checkEdge(int src, int dst) {
        LinkedList<Node> current = aslist.get(src);
        Node dstNode = aslist.get(dst).get(0);
        for (Node node : current) {
            if (node == dstNode) {
                return true;
            }
        }
        return false;
    }
//  public void print() {
//        for(LinkedList<Node> current : aslist){
//            for(Node node: current){
//                System.out.print(node.data + " - > ");
//            }
//            System.out.println("");
//        }
//    }

    public void print() {
        for (int i = 0; i < aslist.size(); i++) {
            System.out.print("Node " + aslist.get(i).get(0).data + " -> ");
            for (int j = 1; j < aslist.get(i).size(); j++) {
                System.out.print(aslist.get(i).get(j).data + " ");
            }
            System.out.println();
        }
    }

    void addNode(Node node) {
//        LinkedList<Node> current = new LinkedList<>();
//        current.add(node);
//        aslist.add(current);
        LinkedList<Node> current = new LinkedList<>();
        current.add(node);
        aslist.add(current);
        weights.put(aslist.size() - 1, new HashMap<>());
    }

//   public void BFS(int start) {
//    Queue<Node> queue = new LinkedList<>();
//    HashSet<Node> visited = new HashSet<>();
//
//    Node startNode = aslist.get(start).get(0);
//    queue.add(startNode);
//    visited.add(startNode);
//
//    while (!queue.isEmpty()) {
//        Node current = queue.poll();
//        System.out.print(current.data + " -> ");
//        int currentIndex = -1;
//        for (int i = 0; i < aslist.size(); i++) {
//            if (aslist.get(i).get(0) == current) {
//                currentIndex = i;
//                break;
//            }
//        }
//
//        for (Node neighbor : aslist.get(currentIndex)) {
//            if (!visited.contains(neighbor)) {
//                queue.add(neighbor);
//                visited.add(neighbor);
//            }
//        }
//    }
//    System.out.println("END");
//}
    public void BFS(int start) {
        HashSet<Node> visited = new HashSet<>();

        // Nếu `start` hợp lệ, duyệt từ `start` trước
        if (start >= 0 && start < aslist.size() && !aslist.get(start).isEmpty()) {
            BFS_Util(aslist.get(start).get(0), visited);
        }

        // Nếu đồ thị không liên thông, duyệt tiếp các thành phần chưa thăm
        for (List<Node> nodeList : aslist) {
            if (!nodeList.isEmpty() && !visited.contains(nodeList.get(0))) {
                BFS_Util(nodeList.get(0), visited);
            }
        }
    }

    private void BFS_Util(Node start, HashSet<Node> visited) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " -> ");

            for (Node neighbor : aslist.get(0)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println("END");
    }

    public boolean isConnected() {
        if (aslist.isEmpty()) {
            return true;
        }

        HashSet<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        Node startNode = aslist.get(0).get(0);
        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int currentIndex = -1;
            for (int i = 0; i < aslist.size(); i++) {
                if (aslist.get(i).get(0) == current) {
                    currentIndex = i;
                    break;
                }
            }

            for (Node neighbor : aslist.get(currentIndex)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return visited.size() == aslist.size();
    }

    public Map<Integer, Integer> shortestPath(int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> dist = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < aslist.size(); i++) {
            dist.put(i, Integer.MAX_VALUE);
        }
        dist.put(src, 0);
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            if (visited.contains(u)) {
                continue;
            }
            visited.add(u);

            for (int v : weights.get(u).keySet()) {
                int weight = weights.get(u).get(v);
                if (dist.get(u) + weight < dist.get(v)) {
                    dist.put(v, dist.get(u) + weight);
                    pq.add(new int[]{v, dist.get(v)});
                }
            }
        }
        return dist;
    }

}
/*public class MyGraph {
    private ArrayList<LinkedList<Node>> adjList;
    
    public MyGraph() {
        adjList = new ArrayList<>();
    }
    
    public void addNode(Node node) {
        LinkedList<Node> newNodeList = new LinkedList<>();
        newNodeList.add(node);
        adjList.add(newNodeList);
    }
    
    public void addEdge(int src, int dst) {
        Node dstNode = adjList.get(dst).get(0);
        adjList.get(src).add(dstNode);
    }
    
    public void print() {
        for (LinkedList<Node> list : adjList) {
            System.out.print("Node " + list.get(0).data + " -> ");
            for (int j = 1; j < list.size(); j++) {
                System.out.print(list.get(j).data + " ");
            }
            System.out.println();
        }
    }
    
    public void BFS(int start) {
        boolean[] visited = new boolean[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                traverse(i, visited);
            }
        }
        System.out.println("END");
    }
    
    private void traverse(int i, boolean[] visited) {
      Queue<Node> queue = new LinkedList<>();
        queue.add(adjList.get(i).get(0));
        visited[i] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " -> ");

            int currentIndex = getNodeIndex(current);
            for (Node neighbor : adjList.get(currentIndex)) {
                int neighborIndex = getNodeIndex(neighbor);
                if (neighborIndex != -1 && !visited[neighborIndex]) {
                    queue.add(neighbor);
                    visited[neighborIndex] = true;
                }
            }
        }
    }
    
    private int getNodeIndex(Node node) {
        for (int i = 0; i < adjList.size(); i++) {
            if (adjList.get(i).get(0).equals(node)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean isConnected() {
        boolean[] visited = new boolean[adjList.size()];
        traverse(0, visited);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
    
    public List<Character> findPathBFS(int start, int end) {
        Map<Node, Node> parentMap = new HashMap<>();
        boolean[] visited = new boolean[adjList.size()];
        Queue<Node> queue = new LinkedList<>();
        queue.add(adjList.get(start).get(0));
        visited[start] = true;
        parentMap.put(adjList.get(start).get(0), null);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data == adjList.get(end).get(0).data) {
                break;
            }
            
            int currentIndex = getNodeIndex(current);
            for (Node neighbor : adjList.get(currentIndex)) {
                int neighborIndex = getNodeIndex(neighbor);
                if (neighborIndex != -1 && !visited[neighborIndex]) {
                    queue.add(neighbor);
                    visited[neighborIndex] = true;
                    parentMap.put(neighbor, current);
                }
            }
        }
        
        List<Character> path = new ArrayList<>();
        Node step = adjList.get(end).get(0);
        while (step != null) {
            path.add(step.data);
            step = parentMap.get(step);
        }
        Collections.reverse(path);
        if (path.size() == 1 && path.get(0) != adjList.get(start).get(0).data) {
        System.out.println("false");
    } else {
        System.out.print("Đường đi từ " + start + " đến " + end + ": ");
        for (char node : path) {
            System.out.print(node + " -> ");
        }
        System.out.println("END");
    }

        return path;
    }
}
 */

//class Node<T> {
//    T data;
//    Node(T data) {
//        this.data = data;
//    }
//}
//
//class MyGraph<T> {
//    private ArrayList<LinkedList<Integer>> adjList;
//    private HashMap<T, Integer> nodeIndex;
//    private HashMap<Integer, Node<T>> nodeMap;
//    private boolean isDirected;
//    
//    MyGraph(boolean isDirected) {
//        this.isDirected = isDirected;
//        adjList = new ArrayList<>();
//        nodeMap = new HashMap<>();
//        nodeIndex = new HashMap<>();
//    }
//    
//    public void addNode(T data) {
//        int id = nodeMap.size();
//        nodeMap.put(id, new Node<>(data));
//        nodeIndex.put(data, id);
//        adjList.add(new LinkedList<>());
//    }
//    
//    public void addEdge(T src, T dst) {
//        if (nodeIndex.containsKey(src) && nodeIndex.containsKey(dst)) {
//            int srcId = nodeIndex.get(src);
//            int dstId = nodeIndex.get(dst);
//            adjList.get(srcId).add(dstId);
//            if (!isDirected) {
//                adjList.get(dstId).add(srcId);
//            }
//        }
//    }
//    
//    public void print() {
//        for (int i = 0; i < adjList.size(); i++) {
//            System.out.print("Node " + nodeMap.get(i).data + " -> ");
//            for (int neighbor : adjList.get(i)) {
//                System.out.print(nodeMap.get(neighbor).data + " ");
//            }
//            System.out.println();
//        }
//    }
//    
//    public void BFS(T start) {
//        if (!nodeIndex.containsKey(start)) return;
//        boolean[] visited = new boolean[adjList.size()];
//        traverse(nodeIndex.get(start), visited);
//    }
//    
//    private void traverse(int start, boolean[] visited) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(start);
//        visited[start] = true;
//        
//        while (!queue.isEmpty()) {
//            int current = queue.poll();
//            System.out.print(nodeMap.get(current).data + " -> ");
//            
//            for (int neighbor : adjList.get(current)) {
//                if (!visited[neighbor]) {
//                    queue.add(neighbor);
//                    visited[neighbor] = true;
//                }
//            }
//        }
//        System.out.println("END");
//    }
//    
//    public boolean isConnected() {
//        boolean[] visited = new boolean[adjList.size()];
//        traverse(0, visited);
//        
//        for (boolean v : visited) {
//            if (!v) return false;
//        }
//        return true;
//    }
//    
//    public boolean isStronglyConnected() {
//        for (int i = 0; i < adjList.size(); i++) {
//            boolean[] visited = new boolean[adjList.size()];
//            traverse(i, visited);
//            for (boolean v : visited) {
//                if (!v) return false;
//            }
//        }
//        return true;
//    }
//    
//    public List<T> findPathBFS(T start, T end) {
//        if (!nodeIndex.containsKey(start) || !nodeIndex.containsKey(end)) return Collections.emptyList();
//        
//        int startId = nodeIndex.get(start);
//        int endId = nodeIndex.get(end);
//        
//        Queue<Integer> queue = new LinkedList<>();
//        Map<Integer, Integer> parent = new HashMap<>();
//        boolean[] visited = new boolean[adjList.size()];
//        
//        queue.add(startId);
//        visited[startId] = true;
//        parent.put(startId, -1);
//        
//        while (!queue.isEmpty()) {
//            int current = queue.poll();
//            if (current == endId) break;
//            
//            for (int neighbor : adjList.get(current)) {
//                if (!visited[neighbor]) {
//                    queue.add(neighbor);
//                    visited[neighbor] = true;
//                    parent.put(neighbor, current);
//                }
//            }
//        }
//        
//        List<T> path = new LinkedList<>();
//        for (int at = endId; at != -1; at = parent.getOrDefault(at, -1)) {
//            path.add(0, nodeMap.get(at).data);
//        }
//        
//        return path.get(0).equals(start) ? path : Collections.emptyList();
//    }
