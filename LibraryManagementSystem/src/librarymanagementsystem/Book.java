/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem;

/**
 *
 * @author Admin
 */
public class Book {

    String bcode;
    String title;
    int quantity;
    int lended;
    double price;

    public Book() {
    }

    public Book(String bcode, String title, int quantity, int lended, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Book[bcode=%s, title=%s, quantity=%d, lended=%d, price=%.2f]",
                bcode, title, quantity, lended, price);
    }

}
