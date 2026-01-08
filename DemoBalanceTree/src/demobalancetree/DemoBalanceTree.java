/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demobalancetree;

/**
 *
 * @author Admin
 */
public class DemoBalanceTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AVLTree bst = new AVLTree();
        bst.insert(7);
        bst.insert(4);
        bst.insert(15);
        bst.insert(1);
        bst.insert(5);
        bst.insert(8);
        bst.insert(20);
        bst.insert(30);
        System.out.println("BFS: ");

        bst.BFS();
        System.out.println(" ");
        bst.deletebyCopy(15);
        bst.BFS();
    }

}
