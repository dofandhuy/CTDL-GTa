/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binarysearchtreedemo;

/**
 *
 * @author hathi
 */
public class BinarySearchTreeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BST bst=new BST();
        bst.insert(8);
        bst.insert(3);
        bst.insert(1);
        bst.insert(2);
        bst.insert(6);
        bst.insert(0);
        bst.insert(4);
        bst.insert(7);
        bst.insert(10);
        bst.insert(14);
        bst.insert(13);
        bst.insert(5);
        System.out.print("BFS:");
        bst.BFS();
        System.out.println("");
        System.out.print("Preorder:");
        bst.preorder();
        System.out.println("");
        System.out.println("number of Node:"+bst.count());
        bst.deletebyCopy(3); 
        bst.BFS();
        System.out.println(" ");
    }
    
}
