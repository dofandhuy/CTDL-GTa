/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package findingpathinmaze;

import java.util.Stack;

/**
 *
 * @author Admin
 */
public class FindPath {
      
        // Các hướng di chuyển
    private static final int[] dx = {1, 0, 0, -1}; // D, R, L, U
    private static final int[] dy = {0, 1, -1, 0};
    private static final char[] dir = {'D', 'R', 'L', 'U'}; // Ký tự thể hiện hướng đi
    
    static void findPathWithStack(int[][] maze) {
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        Stack<Node> stack = new Stack<>();

        // Đẩy điểm xuất phát vào Stack
        stack.push(new Node(0, 0, ""));

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            int x = current.x, y = current.y;
            String path = current.path;

            // Nếu đạt tới đích, in đường đi
            if (x == n - 1 && y == n - 1) {
                System.out.println(path);
                continue;
            }

            // Đánh dấu đã thăm
            visited[x][y] = true;

            // Thử các hướng theo thứ tự D, R, L, U
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (isSafe(maze, newX, newY, visited)) {
                    stack.push(new Node(newX, newY, path + dir[i]));
                }
            }
        }
    }

    // Kiểm tra xem ô có hợp lệ không
    private static boolean isSafe(int[][] maze, int x, int y, boolean[][] visited) {
        int n = maze.length;
        return (x >= 0 && y >= 0 && x < n && y < n && maze[x][y] == 1 && !visited[x][y]);
    }
}
