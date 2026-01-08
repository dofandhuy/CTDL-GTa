/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package findingpathinmaze;

/**
 *
 * @author Admin
 */
public class FindingPathInMaze {
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        FindPath path= new FindPath();
        System.out.println("Các đường đi khả thi:");
        path.findPathWithStack(maze);
    }
}
    
    

