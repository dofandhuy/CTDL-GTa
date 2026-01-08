/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demolinkedlist;

/**
 *
 * @author Admin
 */
public class DemoLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MySingedLinkedList myList = new MySingedLinkedList();
        myList.insertFirst(new Employee("Lan", 20));
        myList.insertFirst(new Employee("Nam", 25));
        myList.insertFirst(new Employee("Manh", 25));
        myList.insertAt(2, new Employee("Huong", 10));
        myList.insertAt(5, new Employee("Huong", 10));
        System.out.println("My list: ");
        myList.travel();
//       Employee x=myList.removeFirst();
        Node q = myList.head;
        myList.removeAfter(q);
        System.out.println("My list: ");
        myList.travel();
        System.out.println("length of nylist: " + myList.size());

    }

}
