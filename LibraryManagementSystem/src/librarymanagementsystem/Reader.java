/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem;

/**
 *
 * @author Admin
 */
public class Reader {

    String rcode;
    String name;
    int byear;

    public Reader() {
    }

    public Reader(String rcode, String name, int byear) {
        this.rcode = rcode;
        this.name = name;
        this.byear = byear;
    }

    @Override
    public String toString() {
        return String.format("Reader [rcode=%s, name=%s, byear=%d]", rcode, name, byear);
    }

}
