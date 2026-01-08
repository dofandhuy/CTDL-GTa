/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem;

/**
 *
 * @author Admin
 */
public class BorrowRecord {

    String bcode;
    String rcode;
    int state;

    public BorrowRecord() {
    }

    public BorrowRecord(String bcode, String rcode, int state) {
        this.bcode = bcode;
        this.rcode = rcode;
        this.state = state;
    }
 @Override
    public String toString() {
        return String.format("BorrowRecord[bcode=%s, rcode=%s, state=%d]", bcode, rcode, state);
    }
}
