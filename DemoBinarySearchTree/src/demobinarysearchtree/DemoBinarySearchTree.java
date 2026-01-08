/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demobinarysearchtree;

/**
 *
 * @author Admin
 */
public class DemoBinarySearchTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(8);
        bst.insert(3);
        bst.insert(1);
        bst.insert(6);
        bst.insert(4);
        bst.insert(7);
        bst.insert(10);
        bst.insert(14);
        bst.insert(13);

        System.out.println("BFS: ");
        bst.BFS();
//        System.out.println(" ");
//        System.out.println("Preorder: ");
//        bst.preorder();
//        System.out.println(" ");
//        System.out.println("inorder: ");
//        bst.inorder();
//        System.out.println(" ");
//        System.out.println("postrder: ");
//        bst.postorder();
        bst.deletebyCopy(10);
        System.out.println("BFS: ");
        bst.BFS();

    }

}
