/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demobalancetree;

/**
 *
 * @author Admin
 */
public class Node {

    int key;
    Node right, left;
    int balance;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.balance = 0;
    }
}
