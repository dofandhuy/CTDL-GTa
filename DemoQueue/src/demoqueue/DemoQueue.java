/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demoqueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Admin
 */
public class DemoQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<Integer> Q1= new LinkedList();//
        Q1.add(1);
        Q1.add(10);
        Q1.add(8);
        Q1.add(5);
        while(!Q1.isEmpty()){
            Integer x= Q1.remove();
            System.out.print(x+" ");
        }
        System.out.println();
       
        
        Queue<Integer> Q2= new ArrayDeque();//
        Q2.add(2);
        Q2.add(3);
        Q2.add(5);
        Q2.add(8);
        while(!Q2.isEmpty()){
            Integer x= Q2.remove();
            System.out.print(x+" ");
        }
        System.out.println();
        
        
        ArrayDeque<Integer> Q3= new ArrayDeque();
        Q3.addFirst(3);
        Q3.addFirst(10);
        Q3.addFirst(5);
        Q3.addFirst(4);
        while(!Q3.isEmpty()){
            Integer x= Q3.removeLast();
            System.out.print(x+ " ");   
        }
        System.out.println("");
        
        
        PriorityQueue<Integer> Q4= new PriorityQueue();
        Q4.add(1);
        Q4.add(4);
        Q4.add(2);
        Q4.add(3);
        while(!Q4.isEmpty()){
            Integer x= Q4.remove();
            System.out.print(x+ " ");   
        }
        System.out.println("");
    }
    
}
