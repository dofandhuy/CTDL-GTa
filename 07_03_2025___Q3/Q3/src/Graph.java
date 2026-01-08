/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------

public class Graph {

    int[][] a;
    int n;
    char v[];
    int deg[];

    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }

    void loadData(int k) //do not edit this function
    {
        RandomAccessFile f;
        int i, j, x;
        String s;
        StringTokenizer t;
        a = new int[20][20];
        try {
            f = new RandomAccessFile("data.txt", "r");
            for (i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
            s = s.trim();
            n = Integer.parseInt(s);
            for (i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for (j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            f.close();
        } catch (Exception e) {
        }

    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
    }

    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes(" " + v[i]);
    }

    void breadth(boolean[] en, int i, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i, f);
            }
        }
    }

    void depth(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth(visited, i, f);
            }
        }
    }

    void depth(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i, f);
            }
        }
    }

    int deg(int i) {
        int s, j;
        s = 0;
        for (j = 0; j < n; j++) {
            if (a[i][j] > 0 && a[i][j] < 999) {
                s += a[i][j];
            }
        }
//    s += a[i][i];
        return (s);
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void depthWithDegree(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        f.writeBytes(" " + v[k] + "(" + deg(k) + ")");
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depthWithDegree(visited, i, f);
            }
        }
    }

    void depthWithDegree(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        Arrays.fill(visited, false);
        depthWithDegree(visited, k, f);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                depthWithDegree(visited, i, f);
            }
        }
    }

    void f1(int lineNum) throws Exception {
        loadData(lineNum);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(1, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        depthWithDegree(1, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
//===========================================================================

    void breadthWithDegree(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        Arrays.fill(visited, false);
        List<Integer> vertexOrder = new ArrayList<>();
        List<Integer> degreeOrder = new ArrayList<>();

        int[] queue = new int[n];
        int front = 0, rear = 0;
        queue[rear++] = k;
        visited[k] = true;

        while (front < rear) {
            int u = queue[front++];
            vertexOrder.add((int) v[u]);
            degreeOrder.add(deg(u));
            for (int i = 0; i < n; i++) {
                if (!visited[i] && a[u][i] > 0) {
                    queue[rear++] = i;
                    visited[i] = true;
                }
            }
        }

        for (int vertex : vertexOrder) {
            f.writeBytes(" " + (char) vertex);
        }
        f.writeBytes("\r\n");
        for (int degree : degreeOrder) {
            f.writeBytes(" " + degree);
        }
        f.writeBytes("\r\n");
    }

    void f2(int lineNum) throws Exception {
        loadData(lineNum);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        breadthWithDegree(0, f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//===========================================================================
/*
Algorithm for finding an Euler cycle from the v X using stack 
//Input: Connected graph G with all vertices having even degrees
//Output: Euler cycle

declare a stack S of characters
declare empty array E (which will contain Euler cycle)
push the v X to S
while(S is not empty)
 {r = top element of the stack S 
  if r is isolated then remove it from the stack and put it to E
   else
   select the first v Y (by alphabet order), which is aacent
   to r, push  Y  to  S and remove the edge (r,Y) from the graph   
 }
 the last array E obtained is an Euler cycle of the graph
     */
    int count = 0;

    void depthWithDegree(boolean[] visited, int k, List<Character> result) {
        result.add(v[k]);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depthWithDegree(visited, i, result);
            }
        }
    }

    void depthWithDegree(int k, RandomAccessFile f, int start, int end) throws Exception {
        boolean[] visited = new boolean[20];
        Arrays.fill(visited, false);
        List<Character> result = new ArrayList<>();
        depthWithDegree(visited, k, result);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                depthWithDegree(visited, i, result);
            }
        }

        // Chỉ in các đỉnh từ vị trí 3 đến 6 (0-based index)
        for (int i = start; i < Math.min(end, result.size()); i++) {
            f.writeBytes(" " + result.get(i));
        }
        f.writeBytes("\r\n");
    }

    void f3(int lineNum) throws Exception {
        loadData(lineNum);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(1, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        depthWithDegree(1, f, 2, 6);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void breadthWithRange(boolean[] visited, int k, List<Character> result) {
        List<Integer> queue = new ArrayList<>();
        queue.add(k);
        visited[k] = true;
        while (!queue.isEmpty()) {
            int r = queue.remove(0);
            result.add(v[r]);
            for (int i = 0; i < n; i++) {
                if (!visited[i] && a[r][i] > 0) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    void breadthWithRange(int k, RandomAccessFile f, int start, int end) throws Exception {
        boolean[] visited = new boolean[20];
        Arrays.fill(visited, false);
        List<Character> result = new ArrayList<>();
        breadthWithRange(visited, k, result);

        // Chỉ in các đỉnh từ vị trí 2 đến 4 (0-based index)
        for (int i = start; i < Math.min(end, result.size()); i++) {
            f.writeBytes(" " + result.get(i));
        }
        f.writeBytes("\r\n");
    }

    void f4(int lineNum) throws Exception {
        loadData(lineNum);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(1, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        breadthWithRange(1, f, 1, 4);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void dijkstra(int start, int end, RandomAccessFile f) throws Exception {
        int[] dist = new int[n];
        int[] prev = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, 999);
        Arrays.fill(prev, -1);
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            if (dist[u] == 999) {
                break;
            }
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (a[u][v] > 0 && a[u][v] < 999) {
                    int newDist = dist[u] + a[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        prev[v] = u;
                    }
                }
            }
        }

        List<Character> path = new ArrayList<>();
        List<Integer> distances = new ArrayList<>();

        for (int at = end; at != -1; at = prev[at]) {
            path.add(v[at]);
            distances.add(dist[at]);
        }
        Collections.reverse(path);
        Collections.reverse(distances);

        for (char c : path) {
            f.writeBytes(c + " ");
        }
        f.writeBytes("\r\n");

        for (int d : distances) {
            f.writeBytes(d + " ");
        }
        f.writeBytes("\r\n");
    }

    void f5(int lineNum) throws Exception {
        loadData(lineNum);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        dijkstra(1, 4, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    
      void dijkstraR(int start, int end, RandomAccessFile f) throws Exception {
        int[] dist = new int[n];
        int[] prev = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, 999);
        Arrays.fill(prev, -1);
        dist[start] = 0;
        
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }
            
            if (dist[u] == 999) break;
            visited[u] = true;
            
            for (int v = 0; v < n; v++) {
                if (a[u][v] > 0 && a[u][v] < 999) {
                    int newDist = dist[u] + a[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        prev[v] = u;
                    }
                }
            }
        }
        
        List<Character> path = new ArrayList<>();
        for (int at = end; at != -1; at = prev[at]) {
            path.add(v[at]);
        }
        Collections.reverse(path);
        
        f.writeBytes(path.get(0) + " " + path.get(path.size() - 1) + "->" + dist[end] + "\r\n");
    }
    void f6(int lineNum) throws Exception {
        loadData(lineNum);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        
        dijkstraR(1, 4, f);
        
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, 999);
        dist[0] = 0;
        
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }
            
            if (dist[u] == 999) break;
            visited[u] = true;
            
            for (int v = 0; v < n; v++) {
                if (a[u][v] > 0 && a[u][v] < 999) {
                    int newDist = dist[u] + a[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                    }
                }
            }
        }
        
        List<String> lastFour = new ArrayList<>();
        if (dist[0] < 999) lastFour.add(v[0] + "-" + dist[0]);
        if (dist[2] < 999) lastFour.add(v[2] + "-" + dist[2]);
        if (dist[5] < 999) lastFour.add(v[5] + "-" + dist[5]);
        
        f.writeBytes(String.join(" ", lastFour) + "\r\n");
        //-------------------------------------------------------------------------------------
        
        f.close();
    }
    
    
    void dijkstraRR(int start, int end, RandomAccessFile f) throws Exception {
        int[] dist = new int[n];
        int[] prev = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, 999);
        Arrays.fill(prev, -1);
        dist[start] = 0;
        
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }
            
            if (dist[u] == 999) break;
            visited[u] = true;
            
            for (int v = 0; v < n; v++) {
                if (a[u][v] > 0 && a[u][v] < 999) {
                    int newDist = dist[u] + a[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        prev[v] = u;
                    }
                }
            }
        }
        
        List<Character> path = new ArrayList<>();
        for (int at = end; at != -1; at = prev[at]) {
            path.add(v[at]);
        }
        Collections.reverse(path);
        
        for (char c : path) {
            f.writeBytes(c + " ");
        }
        f.writeBytes("\r\n");
        f.writeBytes(dist[end] + "\r\n");
    }

    void f7(int lineNum) throws Exception {
        loadData(lineNum);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
       dijkstraRR(1, 4, f);
        
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, 999);
        dist[1] = 0;
        
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }
            
            if (dist[u] == 999) break;
            visited[u] = true;
            
            for (int v = 0; v < n; v++) {
                if (a[u][v] > 0 && a[u][v] < 999) {
                    int newDist = dist[u] + a[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                    }
                }
            }
        }
        
        List<String> firstFour = new ArrayList<>();
        if (dist[4] < 999) firstFour.add(v[4] + "-" + dist[4]);
        if (dist[3] < 999) firstFour.add(v[3] + "-" + dist[3]);
        if (dist[5] < 999) firstFour.add(v[5] + "-" + dist[5]);
        if (dist[6] < 999) firstFour.add(v[6] + "-" + dist[6]);
        
        f.writeBytes(String.join(" ", firstFour) + "\r\n");
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
    void eulerCycle(int u, RandomAccessFile f) throws Exception {
        List<Character> cycle = new ArrayList<>();
        int[][] tempGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(a[i], 0, tempGraph[i], 0, n);
        }
        findEulerCycle(u, tempGraph, cycle);
        for (char c : cycle) {
            f.writeBytes(c + " ");
        }
        f.writeBytes("\r\n");
    }

    void findEulerCycle(int u, int[][] graph, List<Character> cycle) {
        for (int v = 0; v < n; v++) {
            while (graph[u][v] > 0) {
                graph[u][v]--;
                graph[v][u]--;
                findEulerCycle(v, graph, cycle);
            }
        }
        cycle.add(v[u]);
    }

    void f8(int lineNum) throws Exception {
        loadData(lineNum);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        eulerCycle(4, f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

}
