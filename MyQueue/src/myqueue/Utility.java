
package myqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Utility {
   private Queue<Integer> queue;

    public Utility() {
        queue = new LinkedList<>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void clear() {
        queue.clear();
    }

    public void enqueue(int x) {
        queue.add(x);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.poll();
    }

    public int first() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.peek();
    }

    public void traverse() {
        System.out.println("Queue elements: " + queue);
    }
    
    public static void convertToBinary(double number) {
        if (number >= 1 || number <= 0) {
            throw new IllegalArgumentException("Number must be between 0 and 1");
        }

        StringBuilder binary = new StringBuilder("0.");
        Queue<Integer> queue = new LinkedList<>();

        while (number > 0 && binary.length() < 32) { // Giới hạn tối đa 32 bit
            number *= 2;
            int bit = (int) number;
            queue.add(bit);
            number -= bit;
        }

        while (!queue.isEmpty()) {
            binary.append(queue.poll());
        }

        System.out.println("Binary representation: " + binary); 
}
}
