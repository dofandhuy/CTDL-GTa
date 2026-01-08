/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package waterjugproblem;
import java.util.*;
/**
 *
 * @author Admin
 */
public class MeasureWater {
    class State {
        int x, y;
        State(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof State) {
                State other = (State) obj;
                return this.x == other.x && this.y == other.y;
            }
            return false;
        }
    }
        public boolean canMeasureWater(int a, int b, int target) {
        if (target > a && target > b) return false;
        
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        
        queue.add(new State(0, 0));
        visited.add(new State(0, 0));
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            int x = current.x, y = current.y;
            
            if (x == target || y == target) return true;
            
            List<State> nextStates = Arrays.asList(
                new State(a, y),     // Đổ đầy bình a
                new State(x, b),     // Đổ đầy bình b
                new State(0, y),     // Đổ hết nước trong bình a
                new State(x, 0),     // Đổ hết nước trong bình b
                new State(x - Math.min(x, b - y), y + Math.min(x, b - y)), // Đổ nước từ a sang b
                new State(x + Math.min(y, a - x), y - Math.min(y, a - x))  // Đổ nước từ b sang a
            );
            
            for (State nextState : nextStates) {
                if (!visited.contains(nextState)) {
                    queue.add(nextState);
                    visited.add(nextState);
                }
            }
        }
        
        return false;
        }
}
