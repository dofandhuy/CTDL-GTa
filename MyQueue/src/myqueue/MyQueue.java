/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myqueue;

/**
 *
 * @author Admin
 */
public class MyQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Utility q = new Utility();
        
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        
        q.traverse();
        
        System.out.println("First element: " + q.first());
        System.out.println("Dequeued element: " + q.dequeue());
        
        q.traverse();
        
        System.out.println("Is queue empty? " + q.isEmpty());
        
        q.clear();
        System.out.println("Is queue empty after clearing? " + q.isEmpty());

        // Chuyển đổi số thực nhỏ hơn 1 sang nhị phân
        q.convertToBinary(0.735); 
    }
    
}
